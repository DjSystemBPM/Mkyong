![Hibernate Tutorials](https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png)

# TUTORIAL HIBERNATE	

Ejemplo de Hibernate el uso de los siguientes componentes:

* Componente Interceptor: para manejar las transacciones en una base de datos.


## PASOS PARA CONSTRUIR EL PROYECTO

Estas son las instrucciones para levantar el proyecto de manera correcta

### LIBRERIAS

* Hibernate 3.6.3.Final
* Eclipse 3.6
* Maven 3.0.3

### ARCHIVO DE DEPENDENCIAS MAVEN (pom.xml)

```
<project ...>
	<repositories>
		<repository>
			<id>JBoss repository</id>
			<url>http://repository.jboss.org/nexus/content/groups/public/</url>
		</repository>
	</repositories>

	<dependencies>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>3.6.3.Final</version>
		</dependency>

		<!-- slf4j-log4j -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.6.1</version>
		</dependency>

	</dependencies>
</project>

```

### SCRIPT BASE DE DATOS 


```
MYSQL

CREATE DATABASE MKYONG;

USE MKYONG;

DROP TABLE IF EXISTS auditlog;
CREATE TABLE  auditlog (
  AUDIT_LOG_ID bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  ACTION varchar(100) NOT NULL,
  DETAIL text NOT NULL,
  CREATED_DATE date NOT NULL,
  ENTITY_ID bigint(20) unsigned NOT NULL,
  ENTITY_NAME varchar(255) NOT NULL,
  PRIMARY KEY (AUDIT_LOG_ID)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS stock;

CREATE TABLE stock (
  STOCK_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
  STOCK_CODE varchar(10) NOT NULL,
  STOCK_NAME varchar(20) NOT NULL,
  PRIMARY KEY (STOCK_ID) USING BTREE,
  UNIQUE KEY UNI_STOCK_NAME (STOCK_NAME),
  UNIQUE KEY UNI_STOCK_CODE (STOCK_CODE) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS stock_detail;

CREATE TABLE stock_detail (
 STOCK_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
 COMP_NAME varchar(100) NOT NULL,
 COMP_DESC varchar(255) NOT NULL,
 REMARK varchar(255) NOT NULL,
 LISTED_DATE date NOT NULL,
 PRIMARY KEY (STOCK_ID) USING BTREE,
 CONSTRAINT FK_STOCK_ID FOREIGN KEY (STOCK_ID) REFERENCES stock (STOCK_ID)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

```

### 1.- CREAMOS LA INTERFAZ

``` 
public interface IAuditLog {

	public Long getId();
	public String getLogDeatil();
}

``` 


### 2.- MAPEAMOS LA TABLA AUDITLOG

``` 
@Entity
@Table(name = "auditlog", catalog = "mkyong")
public class AuditLog implements java.io.Serializable {

	private Long auditLogId;
	private String action;
	private String detail;
	private Date createdDate;
	private long entityId;
	private String entityName;
        ...
}

``` 

### 3.- EN EL POJO DE AUDITLOG IMPLEMENTAMOS LA INTERFAZ IAuditLog

``` 
...
@Entity
@Table(name = "stock", catalog = "mkyong"
public class Stock implements java.io.Serializable, IAuditLog {
...
        @Transient
	@Override
	public Long getId(){
		return this.stockId.longValue();
	}

	@Transient
	@Override
	public String getLogDeatil(){
		StringBuilder sb = new StringBuilder();
		sb.append(" Stock Id : ").append(stockId)
		.append(" Stock Code : ").append(stockCode)
		.append(" Stock Name : ").append(stockName);

		return sb.toString();
	}
...

``` 


### 4.- CREAMOS LA CLASE AuditLogUtil PARA SALVAR LOS REGISTROS EN LA BASE DE DATOS 

``` 
...
public class AuditLogUtil{

   public static void LogIt(String action,
     IAuditLog entity, Connection conn ){

     Session tempSession = HibernateUtil.getSessionFactory().openSession(conn);

     try {

	AuditLog auditRecord = new AuditLog(action,entity.getLogDeatil()
		, new Date(),entity.getId(), entity.getClass().toString());
	tempSession.save(auditRecord);
	tempSession.flush();

     } finally {
	tempSession.close();
     }
  }
}
``` 


### 5.- CREAMOS EL INTERCEPTOR DE HIBERNATE

``` 
...
public class AuditLogInterceptor extends EmptyInterceptor{

	Session session;
	private Set inserts = new HashSet();
	private Set updates = new HashSet();
	private Set deletes = new HashSet();

	public void setSession(Session session) {
		this.session=session;
	}

	public boolean onSave(Object entity,Serializable id,
		Object[] state,String[] propertyNames,Type[] types)
		throws CallbackException {

		System.out.println("onSave");

		if (entity instanceof IAuditLog){
			inserts.add(entity);
		}
		return false;

	}

	public boolean onFlushDirty(Object entity,Serializable id,
		Object[] currentState,Object[] previousState,
		String[] propertyNames,Type[] types)
		throws CallbackException {

		System.out.println("onFlushDirty");

		if (entity instanceof IAuditLog){
			updates.add(entity);
		}
		return false;

	}

	public void onDelete(Object entity, Serializable id,
		Object[] state, String[] propertyNames,
		Type[] types) {

		System.out.println("onDelete");

		if (entity instanceof IAuditLog){
			deletes.add(entity);
		}
	}

	//called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}

	//called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");

	try{

		for (Iterator it = inserts.iterator(); it.hasNext();) {
		    IAuditLog entity = (IAuditLog) it.next();
		    System.out.println("postFlush - insert");
		    AuditLogUtil.LogIt("Saved",entity, session.connection());
		}

		for (Iterator it = updates.iterator(); it.hasNext();) {
		    IAuditLog entity = (IAuditLog) it.next();
		    System.out.println("postFlush - update");
		    AuditLogUtil.LogIt("Updated",entity, session.connection());
		}

		for (Iterator it = deletes.iterator(); it.hasNext();) {
		    IAuditLog entity = (IAuditLog) it.next();
		    System.out.println("postFlush - delete");
		    AuditLogUtil.LogIt("Deleted",entity, session.connection());
		}

	} finally {
		inserts.clear();
		updates.clear();
		deletes.clear();
	}
       }
}
``` 


### 6.- HABILITAMOS EL INTERCEPTOR

``` 
...
   Session session = null;
   Transaction tx = null;
   try {

	AuditLogInterceptor interceptor = new AuditLogInterceptor();
	session = HibernateUtil.getSessionFactory().openSession(interceptor);
	interceptor.setSession(session);

	//test insert
	tx = session.beginTransaction();
	Stock stockInsert = new Stock();
	stockInsert.setStockCode("1111");
	stockInsert.setStockName("mkyong");
	session.saveOrUpdate(stockInsert);
	tx.commit();

	//test update
	tx = session.beginTransaction();
	Query query = session.createQuery("from Stock where stockCode = '1111'");
	Stock stockUpdate = (Stock)query.list().get(0);
	stockUpdate.setStockName("mkyong-update");
	session.saveOrUpdate(stockUpdate);
	tx.commit();

	//test delete
	tx = session.beginTransaction();
	session.delete(stockUpdate);
	tx.commit();

   } catch (RuntimeException e) {
	try {
		tx.rollback();
	} catch (RuntimeException rbe) {
		// log.error("Couldn’t roll back transaction", rbe);
   }
	throw e;
   } finally {
	if (session != null) {
		session.close();
	}
   }
...
``` 



### 7.- OUTPUT

``` 
onSave
Hibernate:
    insert into mkyong.stock
    (STOCK_CODE, STOCK_NAME)
    values (?, ?)
preFlush
postFlush
postFlush - insert
Hibernate:
    insert into mkyong.auditlog
    (ACTION, CREATED_DATE, DETAIL, ENTITY_ID, ENTITY_NAME)
    values (?, ?, ?, ?, ?)
preFlush
Hibernate:
    select ...
    from mkyong.stock stock0_
    where stock0_.STOCK_CODE='1111'
preFlush
onFlushDirty
Hibernate:
    update mkyong.stock
    set STOCK_CODE=?, STOCK_NAME=?
    where STOCK_ID=?
postFlush
postFlush - update
Hibernate:
    insert into mkyong.auditlog
    (ACTION, CREATED_DATE, DETAIL, ENTITY_ID, ENTITY_NAME)
    values (?, ?, ?, ?, ?)
onDelete
preFlush
Hibernate:
    delete from mkyong.stock where STOCK_ID=?
postFlush
postFlush - delete
Hibernate:
    insert into mkyong.auditlog
    (ACTION, CREATED_DATE, DETAIL, ENTITY_ID, ENTITY_NAME)
    values (?, ?, ?, ?, ?)
``` 



### 8.- VERIFICAMOS LA BASE DE DATOS

![Hibernate Tutorials](http://www.mkyong.com/wp-content/uploads/2010/01/interceptor-example.jpg)

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong.git). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*            
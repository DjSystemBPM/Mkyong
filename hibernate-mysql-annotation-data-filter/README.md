![Hibernate Tutorials](https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png)

# TUTORIAL HIBERNATE	

Ejemplo de Hibernate el uso de los siguientes componentes:

* Componente Data Filter: para el filtrado de datos desde hibernate.


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

### 1.- DATA FILTER EN ANOTACION

``` 
...
@Entity
@FilterDef(name="stockRecordFilter",
parameters=@ParamDef( name="stockRecordFilterParam", type="date" ) )
@Table(name = "stock", catalog = "mkyong")
public class Stock implements java.io.Serializable {
         ...
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	@Filter(
		name = "stockRecordFilter",
		condition="date >= :stockRecordFilterParam"
	)
	public Set<StockDailyRecord> getStockDailyRecords() {
		return this.stockDailyRecords;
	}
...	
``` 

### 2.- APLICANDO EL DATA FILTER

``` 
Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("****** Enabled Filter ******");

        Filter filter = session.enableFilter("stockRecordFilter");
        filter.setParameter("stockRecordFilterParam", new Date());

        Stock stock = (Stock)session.get(Stock.class, 2);
        Set<StockDailyRecord> sets = stock.getStockDailyRecords();

        for(StockDailyRecord sdr : sets){
	System.out.println(sdr.getDailyRecordId());
	System.out.println(sdr.getDate());
}

        System.out.println("****** Disabled Filter ******");

        session.disableFilter("stockRecordFilter");
        //clear the loaded instance and get Stock again, for demo only
        session.evict(stock);

        Stock stock2 = (Stock)session.get(Stock.class, 2);
        Set<StockDailyRecord> sets2 = stock2.getStockDailyRecords();

        for(StockDailyRecord sdr : sets2){
	System.out.println(sdr.getDailyRecordId());
	System.out.println(sdr.getDate());
}

``` 

### 3.- VERIFICANDO LA RESPUESTA

La salida quedara de la siguiente manera

``` 
****** Enabled Filter ******
58
2010-01-31
****** Disabled Filter ******
60
2010-01-02
58
2010-01-31
63
2010-01-23
61
2010-01-03
...

``` 

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong.git). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*            
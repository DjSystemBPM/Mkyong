# HIBERNATE Y MYSQL MAPEO XML

Este es un ejemplo hibernate con mysql y mapeo por xml

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Librerias requeridas
	1.- Maven 2.2.1
	2.- JDK 1.6.0_13
	3.- Hibernate 3.2.3.GA
	4.- MySQL 5.0

### 1.- Creamos la tabla en MySql

```
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `STOCK_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` VARCHAR(10) NOT NULL,
  `STOCK_NAME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

### 2.- POM.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.mkyong.common</groupId>
	<artifactId>HibernateExample</artifactId>
	<packaging>jar</packaging>
	<version>1.0-SNAPSHOT</version>
	<name>HibernateExample</name>
	<url>http://maven.apache.org</url>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>javax.transaction</groupId>
			<artifactId>jta</artifactId>
			<version>1.1</version>
		</dependency>
		<!-- MySQL database driver -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.9</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate</artifactId>
			<version>3.2.3.ga</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-annotations -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-annotations</artifactId>
			<version>3.2.0.ga</version>
		</dependency>

		<!-- Hibernate library dependecy start -->
		<dependency>
			<groupId>dom4j</groupId>
			<artifactId>dom4j</artifactId>
			<version>1.6.1</version>
		</dependency>

		<dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.1.1</version>
		</dependency>

		<dependency>
			<groupId>commons-collections</groupId>
			<artifactId>commons-collections</artifactId>
			<version>3.2.1</version>
		</dependency>

		<dependency>
			<groupId>cglib</groupId>
			<artifactId>cglib</artifactId>
			<version>2.2</version>
		</dependency>
		<!-- Hibernate library dependecy end -->

	</dependencies>
</project>

```

### 3.- Creamos el Pojo para el mapeo Stock.java

```
package com.mkyong.common;

/**
 * Model class for Stock
 */
public class Stock implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer stockId;
	private String stockCode;
	private String stockName;

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}

```

### 4.- Creamos el archivo de Mapeo Stock.hbm.xml

```
<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
    <class name="com.mkyong.common.Stock" table="stock" catalog="mkyong">
        <id name="stockId" type="java.lang.Integer">
            <column name="STOCK_ID" />
            <generator class="identity" />
        </id>
        <property name="stockCode" type="string">
            <column name="STOCK_CODE" length="10" not-null="true" unique="true" />
        </property>
        <property name="stockName" type="string">
            <column name="STOCK_NAME" length="20" not-null="true" unique="true" />
        </property>
    </class>
</hibernate-mapping>
```

### 5.- Creamos el archivo de configuracion de Hibernate
Archivo: hibernate.cfg.xml

```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
                                         "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
 <session-factory>
  <property name="hibernate.bytecode.use_reflection_optimizer">false</property>
  <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
  <property name="hibernate.connection.password">123456</property>
  <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate-mkyong</property>
  <property name="hibernate.connection.username">root</property>
  <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
  <property name="show_sql">true</property>
  <mapping resource="com/mkyong/common/Stock.hbm.xml"/>
 </session-factory>
</hibernate-configuration>
```

### 6.- Creamos una clase Hibernate Utils

Archivo: HibernateUtil.java

```
package com.mkyong.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
```

### 7.- Creamos la clase principal y la ejecutamos

Archivo: App.java

```
package com.mkyong.common;

import org.hibernate.Session;
import com.mkyong.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockId(000002);
        stock.setStockCode("4713");
        stock.setStockName("THELMA");
        
        session.save(stock);
        session.getTransaction().commit();
    }
}
```

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*
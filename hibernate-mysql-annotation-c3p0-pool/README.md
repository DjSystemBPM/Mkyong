![Hibernate Tutorials](https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png)

# TUTORIAL HIBERNATE	

Ejemplo de Hibernate el uso de los siguientes componentes:

* Componente C3P0: para el manejo de pool de conexiones.


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

		<!-- Hibernate c3p0 connection pool -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-c3p0</artifactId>
			<version>3.6.3.Final</version>
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

### 1.- MODIFICAMOS EL ARCHIVO: hibernate.cfg.xml

``` 
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/MKYONG</property>
		<property name="hibernate.connection.username">root</property>
		<property name="hibernate.connection.password">123456</property>
		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
		<property name="show_sql">true</property>

		<property name="hibernate.c3p0.min_size">5</property>
		<property name="hibernate.c3p0.max_size">20</property>
		<property name="hibernate.c3p0.timeout">300</property>
		<property name="hibernate.c3p0.max_statements">50</property>
		<property name="hibernate.c3p0.idle_test_period">3000</property>

		<mapping class="com.mkyong.stock.Stock" />
		<mapping class="com.mkyong.stock.StockDetail" />
	</session-factory>
</hibernate-configuration>

``` 

### 2.- EJECUTAMOS HIBERNATE

Al ejecutar el hibernate veremos que queda algo asi:

![Hibernate Tutorials](http://www.mkyong.com/wp-content/uploads/2009/12/hibernate-c3p0-connection-pool.png)

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong.git). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*            
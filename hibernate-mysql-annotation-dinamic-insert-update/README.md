![Hibernate Tutorials](https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png)

# TUTORIAL HIBERNATE	

Ejemplo de Hibernate el uso de los siguientes componentes:

* Componente Dinamic Insert: para inserciones mas rapidas.
* Componente Dinamic Update: para actualizaciones mas rapidas.


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


CREATE TABLE stock_transaction (
  STOCK_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
  DATE date,
  PRICE_CHANGE int(10),
  PRICE_CLOSE int(10),
  PRICE_OPEN int(10),
  VOLUME int(40),
  PRIMARY KEY (STOCK_ID) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

SELECT * FROM stock_transaction;


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

### 1.- HABILITAR DINAMIC INSERT EN ANOTACION

``` 
@Entity
@Table(name = "stock_transaction", catalog = "mkyong")
@org.hibernate.annotations.Entity(
		dynamicInsert = true
)
public class StockTransaction implements java.io.Serializable {

``` 

### 2.- HABILITAR DINAMIC INSERT EN XML

``` 
<class ... table="stock_transaction" catalog="mkyong" dynamic-insert="true">
        <id name="tranId" type="java.lang.Integer">
            <column name="TRAN_ID" />
            <generator class="identity" />
        </id>
``` 



### 3.- HABILITAR DINAMIC UPDATE EN ANOTACION

``` 
@Entity
@Table(name = "stock_transaction", catalog = "mkyong")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class StockTransaction implements java.io.Serializable {
``` 

### 2.- HABILITAR DINAMIC UPDATE EN XML

``` 
<class ... table="stock_transaction" catalog="mkyong" dynamic-update="true">
        <id name="tranId" type="java.lang.Integer">
            <column name="TRAN_ID" />
            <generator class="identity" />
        </id>
``` 



## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong.git). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*            
USE MKYONG;

CREATE TABLE stock (
  STOCK_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
  STOCK_CODE varchar(10) NOT NULL,
  STOCK_NAME varchar(20) NOT NULL,
  PRIMARY KEY (STOCK_ID) USING BTREE,
  UNIQUE KEY UNI_STOCK_NAME (STOCK_NAME),
  UNIQUE KEY UNI_STOCK_CODE (STOCK_CODE) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

CREATE TABLE category (
  CATEGORY_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
  NAME varchar(10) NOT NULL,
  DESCR varchar(255) NOT NULL,
  PRIMARY KEY (CATEGORY_ID) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

CREATE TABLE  stock_category (
  STOCK_ID int(10) unsigned NOT NULL,
  CATEGORY_ID int(10) unsigned NOT NULL,
  PRIMARY KEY (STOCK_ID,CATEGORY_ID),
  CONSTRAINT FK1_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES category (CATEGORY_ID),
  CONSTRAINT FK1_STOCK_ID FOREIGN KEY (STOCK_ID) REFERENCES stock (STOCK_ID)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
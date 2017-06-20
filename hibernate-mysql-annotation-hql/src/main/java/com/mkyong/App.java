package com.mkyong;

import java.util.List;

import org.hibernate.Session;

import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		// HQL SELECT QUERY EJEMPLO
		// Query query = session.createQuery("from Stock where stockCode = :code
		// ");
		// query.setParameter("code", "7054");
		// List list = query.list();

		
		
		// HQL SELECT QUERY EN DURO EJEMPLO
		// Query query = session.createQuery("from Stock where stockCode =
		// '7054' ");
		// List list = query.list();
		
		
		
		// HQL UPDATE QUERY EJEMPLO
		// Query query = session.createQuery("UPDATE Stock SET stockName =
		// :stockName" + " WHERE stockCode = :stockCode");
		// query.setParameter("stockName", "DIALOG1");
		// query.setParameter("stockCode", "9358");
		// int result = query.executeUpdate();
		// System.out.println("[:::: RESULT: " + result + "::::]");

		
		
		// HQL DELETE QUERY EJEMPLO
		// Query query = session.createQuery("delete Stock where stockCode =
		// :stockCode");
		// query.setParameter("stockCode", "9358");
		// int result = query.executeUpdate();

		
		
		// HQL INSERT QUERY EJEMPLO
		// Query query = session.createQuery("insert into Stock(stock_code,
		// stock_name)" + "select stock_code, stock_name from backup_stock");
		// int result = query.executeUpdate();

		
		
		// EJEMPLO DE SETPARAMETER
		// String hql = "from Stock s where s.stockCode = :stockCode";
		// List result = session.createQuery(hql)
		// .setParameter("stockCode", "9358")
		// .list();

		
		
		// EJEMPLO DE SETSTRING
		// String hql = "from Stock s where s.stockCode = :stockCode";
		// List result = session.createQuery(hql)
		// .setString("stockCode", "9358")
		// .list();

		
		
		// EJEMPLO DE SETPROPERTIES
		// Stock stock = new Stock();
		// stock.setStockCode("9358");
		// String hql = "from Stock s where s.stockCode = :stockCode";
		// List result = session.createQuery(hql)
		// .setProperties(stock)
		// .list();

		
		
		/*
		 * POSITIONAL PARAMETERS
		 */
		// EJEMPLO 1
		String hql = "from Stock s where s.stockCode = ? and s.stockName = ?";
		List result = session.createQuery(hql).setString(0, "9358").setParameter(1, "PRUEBA 2").list();

	}
}

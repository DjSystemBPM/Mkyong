package com.mkyong;

import java.util.List;

import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

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
		//EJEMPLO 1
		String hql = "from Stock s where s.stockCode = ? and s.stockName = ?";
		List result = session.createQuery(hql)
				.setString(0, "9358")
				.setParameter(1, "PRUEBA 2")
				.list();
		
		

		// session.save(stock);
		// session.getTransaction().commit();
	}
}

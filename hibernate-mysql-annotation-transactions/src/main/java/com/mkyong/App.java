package com.mkyong;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDetail;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);

			Stock stock = new Stock();

			stock.setStockCode("4716");
			stock.setStockName("MULTIVA PRUEBA 1");

			StockDetail stockDetail = new StockDetail();
			stockDetail.setCompName("BANCO Holding Malaysia");
			stockDetail.setCompDesc("one stop shopping");
			stockDetail.setRemark("vinci vinci");
			stockDetail.setListedDate(new Date());

			stock.setStockDetail(stockDetail);
			stockDetail.setStock(stock);

			session.save(stock);

			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction" + rbe);
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}

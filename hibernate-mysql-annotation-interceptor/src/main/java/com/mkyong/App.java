package com.mkyong;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.interceptors.AuditLogInterceptor;
import com.mkyong.stock.Stock;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

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
			stockInsert.setStockName("ALFREDO MKYONG");
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
	}
}

package com.mkyong;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.StockTransaction;
import com.mkyong.util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);

			//INSERT DINAMICO
//			StockTransaction stockTran = new StockTransaction();
//			//stockTran.setPriceOpen(new Float("1.2"));
//			//stockTran.setPriceClose(new Float("1.1"));
//			//stockTran.setPriceChange(new Float("10.0"));
//			stockTran.setVolume(40000);
//			stockTran.setDate(new Date());
//			stockTran.setStockId(0003);
//			
//			session.save(stockTran);
			
			
			
			//UPDATE DINAMICO
			Query q = session.createQuery("from StockTransaction where stockId = :stockId ");
			q.setParameter("stockId", 50);
			StockTransaction stockTran = (StockTransaction)q.list().get(0);

			stockTran.setVolume(7000000);
			session.update(stockTran);
			
			
//			Query query = session.createQuery("from StockTransaction");
//			List<StockTransaction> list = query.list();
//			
//			list.forEach(item->System.out.println("ID : " + item.getStockId() + "\t DATE: " + item.getDate() + "\t VOLUME: " + item.getVolume()+ "\t PRICE CHANGE: " + item.getPriceChange()+ "\t PRICE CLOSE: " + item.getPriceClose()+ "\t PRICE OPEN: " + item.getPriceOpen()));			
			

			tx.commit();


		}catch(RuntimeException e){
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				System.out.println("Couldn’t roll back transaction");
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		

	}
}

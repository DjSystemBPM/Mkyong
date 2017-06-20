
package com.mkyong;

import java.util.Date;
import java.util.Set;

import org.hibernate.Filter;
import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("****** Enabled Filter ******");

		Filter filter = session.enableFilter("stockRecordFilter");
		filter.setParameter("stockRecordFilterParam", new Date());

		Stock stock = (Stock) session.get(Stock.class, 2);
		Set<StockDailyRecord> sets = stock.getStockDailyRecords();

		for (StockDailyRecord sdr : sets) {
			System.out.println(sdr.getRecordId());
			System.out.println(sdr.getDate());
		}

		System.out.println("****** Disabled Filter ******");

		session.disableFilter("stockRecordFilter");
		// clear the loaded instance and get Stock again, for demo only
		session.evict(stock);

		Stock stock2 = (Stock) session.get(Stock.class, 2);
		Set<StockDailyRecord> sets2 = stock2.getStockDailyRecords();

		for (StockDailyRecord sdr : sets2) {
			System.out.println(sdr.getRecordId());
			System.out.println(sdr.getDate());
		}

	}

}

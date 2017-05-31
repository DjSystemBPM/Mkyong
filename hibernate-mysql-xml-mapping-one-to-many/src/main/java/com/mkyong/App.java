package com.mkyong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("7059");
		stock.setStockName("FREDY");
		session.save(stock);

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("2.3"));
		stockDailyRecords.setPriceClose(new Float("2.2"));
		stockDailyRecords.setPriceChange(new Float("12.0"));
		stockDailyRecords.setVolume(5000000L);
		
		App app = new App();
		stockDailyRecords.setDate(app.convertStringDate("07/06/2014"));

		stockDailyRecords.setStock(stock);

		stock.getStockDailyRecords().add(stockDailyRecords);

		session.save(stockDailyRecords);

		session.getTransaction().commit();
		System.out.println("Done");
	}
	
	private Date convertStringDate(String fecha){
		
		 	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	        Date date = null;
	        try {

	            date = formatter.parse(fecha);
	            System.out.println(new Date());
	            System.out.println(date);
	            System.out.println(formatter.format(date));
	            
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        return date;
	}
}

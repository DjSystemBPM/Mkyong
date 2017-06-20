package com.mkyong;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.getNamedQuery("findStockByStockCode").setString("stockCode", "9358");
		List list = query.list();

	}
}

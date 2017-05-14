package com.mkyong.common;

import org.hibernate.Session;
import com.mkyong.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL + Annotations");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockId(000003);
        stock.setStockCode("4717");
        stock.setStockName("ALFRED");
        
//        session.save(stock);
        session.delete(stock);

        session.getTransaction().commit();
        
    }
}

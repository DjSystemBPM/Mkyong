package com.mkyong.interceptors;

import java.sql.Connection;
import java.util.Date;

import org.hibernate.Session;

import com.mkyong.stock.Auditlog;
import com.mkyong.util.HibernateUtil;


public class AuditLogUtil {

	public static void LogIt(String action,	InterceptorAuditLog entity, Connection conn ){
			
			Session tempSession = HibernateUtil.getSessionFactory().openSession(conn);
				
			try {
				Auditlog auditRecord = new Auditlog(action, entity.getLogDetail(), new Date(), entity.getId(), entity.getClass().toString());
						
				tempSession.save(auditRecord);
				tempSession.flush();
				
			} finally {	
				tempSession.close();
				
			}
				
		}
}

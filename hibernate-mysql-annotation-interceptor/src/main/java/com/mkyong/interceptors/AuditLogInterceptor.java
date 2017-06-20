package com.mkyong.interceptors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.type.Type;

public class AuditLogInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	Session session;
	private Set<Object> inserts = new HashSet<Object>();
	private Set<Object> updates = new HashSet<Object>();
	private Set<Object> deletes = new HashSet<Object>();

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {

		System.out.println("[:::: SE EJECUTA EL METODO: onSave ::::]");

		if (entity instanceof InterceptorAuditLog) {
			inserts.add(entity);
		}
		return false;

	}

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {

		System.out.println("[:::: SE EJECUTA EL METODO: onFlushDirty ::::]");

		if (entity instanceof InterceptorAuditLog) {
			updates.add(entity);
		}
		return false;

	}

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

		System.out.println("[:::: SE EJECUTA EL METODO: onDelete ::::]");

		if (entity instanceof InterceptorAuditLog) {
			deletes.add(entity);
		}
	}

	//LLAMADA ANTES DEL COMMIT EN LA BASE DE DATOS
	
	@SuppressWarnings("rawtypes")
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}

	//LLAMADA DESPUES DEL COMMIT EN LA BASE DE DATOS
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");

		try {

			for (Iterator it = inserts.iterator(); it.hasNext();) {
				InterceptorAuditLog entity = (InterceptorAuditLog) it.next();
				System.out.println("postFlush - insert");

				AuditLogUtil.LogIt("Saved", entity, session.connection());
			}

			for (Iterator it = updates.iterator(); it.hasNext();) {
				InterceptorAuditLog entity = (InterceptorAuditLog) it.next();
				System.out.println("postFlush - update");
				AuditLogUtil.LogIt("Updated", entity, session.connection());
			}

			for (Iterator it = deletes.iterator(); it.hasNext();) {
				InterceptorAuditLog entity = (InterceptorAuditLog) it.next();
				System.out.println("postFlush - delete");
				AuditLogUtil.LogIt("Deleted", entity, session.connection());
			}

		} finally {
			inserts.clear();
			updates.clear();
			deletes.clear();
		}
	}
}

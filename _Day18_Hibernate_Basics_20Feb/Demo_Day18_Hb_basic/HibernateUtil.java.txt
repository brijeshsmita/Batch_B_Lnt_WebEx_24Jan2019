/**
 * 
 */
package com.lnt.day18.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Smita B Kumar
 * TO provide connectivity with hibernate i.e SessionFactory(hibernate.cfg.xml)
 */
public class HibernateUtil {

	/**
	 * (hibernate.cfg.xml)SessionFactory->Session->(hbm.xml)methods->operate on DB
	 * SessionFactory->Session->HQL Query->operate on DB
	 */
	private static SessionFactory sessionFactory=null;
	static {
		setSessionFactory(new Configuration().configure().buildSessionFactory());
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
	public static void closeFactory() {
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}

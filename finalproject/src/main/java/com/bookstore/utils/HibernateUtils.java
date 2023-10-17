package com.bookstore.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg;
	private static SessionFactory sfc;
	
	public static SessionFactory getSessionFactory() {
		if(sfc == null) {
			try {
				cfg = new Configuration();
				cfg.configure();
				sfc = cfg.buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
				if(sfc != null) {
					sfc.close();
				}
			}
		}
		return sfc;
	}
}

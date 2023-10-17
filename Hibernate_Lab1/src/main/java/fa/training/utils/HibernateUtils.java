package fa.training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				cfg = new Configuration();
				cfg.configure();
				sessionFactory = cfg.buildSessionFactory();

			} catch (Exception e) {
				e.printStackTrace();
				if (sessionFactory != null) {
					sessionFactory.close();
				}
			}
		}
		return sessionFactory;
	}
}

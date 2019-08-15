package br.pro.api.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = createSessionFactory();

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	private static SessionFactory createSessionFactory() {
		try {
			Configuration config = new Configuration().configure();
			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			SessionFactory fabrica = config.buildSessionFactory();
			
			return fabrica;
			
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Erro na criação de sessão" + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
	
   
}

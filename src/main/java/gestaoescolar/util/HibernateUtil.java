package gestaoescolar.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = BuildSessionFactory();
	
	private static SessionFactory BuildSessionFactory() {
		try {
			ServiceRegistry service = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml")
					.build();
			
			Metadata metadata = new MetadataSources(service)
					.getMetadataBuilder()
					.build();
			
			return metadata.getSessionFactoryBuilder().build();
			
		}catch(Throwable t) {
			
			System.out.println(
					"Falha na criação da sessionFactory inicial "
					+t.getMessage()
			);
			
			throw new ExceptionInInitializerError(t);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void CloseHibernateSession(Session session) {
		try {
			session.close();
		}catch (Exception e) {
			
			System.out.println(
					"falha ao encerrar a session do hibernate "
					+ e.getMessage()
			);
		}
	}

}

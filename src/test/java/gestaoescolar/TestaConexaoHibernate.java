package gestaoescolar;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import gestaoescolar.util.HibernateUtil;

@SuppressWarnings("unused")
public class TestaConexaoHibernate {

	@Test
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session.getProperties().toString());
		System.out.println(session.isConnected());
		System.out.println(session.getStatistics());
		
		if(session.isOpen()) {
			session.close();
		}
		
	}

}

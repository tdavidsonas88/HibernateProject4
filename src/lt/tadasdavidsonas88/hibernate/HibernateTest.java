package lt.tadasdavidsonas88.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lt.tadasdavidsonas88.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		// Transient object - laikinas
		UserDetails user = new UserDetails();
		user.setUserName("Test User");
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Persistent object - nuolatinis
		session.save(user);
				
		session.getTransaction().commit();
		session.close();
		
		// Detached object - the ojbect that is no longer persistent
		user.setUserName("Updated username after session close");
			
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Persistent object again
		session.update(user);
		
		session.getTransaction().commit();
		session.close();

	}

}

package lt.tadasdavidsonas88.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateTest {

	public static void main(String[] args) {
			
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from USER_DETAILS where userId > 5");
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of list result = " + users.size());
		
	}

}

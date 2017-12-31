package lt.tadasdavidsonas88.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import lt.tadasdavidsonas88.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
			
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select userName from USER_DETAILS where userId > 5");
		// --- pagination -----
		query.setFirstResult(0);
		query.setMaxResults(3);
		// --------------------
		List<String> userNames = (List<String>) query.list();
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of list result = " + userNames.size());
		
		for (String u : userNames)
			System.out.println(u);
		
	}

}

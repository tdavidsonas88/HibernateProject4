package lt.tadasdavidsonas88.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lt.tadasdavidsonas88.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for(int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			// create
			session.save(user);
		}
		// read
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		System.out.println("User name pulled up is: " + user.getUserName());
		// delete
		session.delete(user);
		
		UserDetails user5 = (UserDetails) session.get(UserDetails.class, 5);
		user5.setUserName("Updated User");
		// update
		session.update(user5);
				
		session.getTransaction().commit();
		session.close();
			


	}

}

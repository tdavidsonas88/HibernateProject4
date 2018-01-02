package lt.tadasdavidsonas88.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import lt.tadasdavidsonas88.dto.UserDetails;

public class HibernateTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
			
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		String minUserId = "5"; 	

//		Query query = session.createQuery("select userName from USER_DETAILS where userId > :userId");
////		Query query = session.createQuery("select userName from USER_DETAILS where userId > ?);
//		query.setInteger("userId", Integer.parseInt(minUserId));
//		query.setInteger(0, Integer.parseInt(minUserId));
		
//		Query query = session.getNamedQuery("UserDetails.byId");
		Query query = session.getNamedQuery("UserDetails.byName");
//		query.setInteger(0, 2);
		query.setString(0, "User 1");
		
		// --- pagination -----
//		query.setFirstResult(0);
//		query.setMaxResults(3);
		// --------------------
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of list result = " + users.size());
		
		for (UserDetails user : users)
			System.out.println(user.getUserName());
		
	}

}

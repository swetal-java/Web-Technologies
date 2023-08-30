package assign04_14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		student stud = new student();
		stud.setId(1);
		stud.setName("java");
		
		Address ad = new Address();
		ad.setAid(1);
		ad.setCity("ahmedabad");
		ad.setState("Gujarat");
		ad.setStreet("123");
		
		stud.setAddress(ad);
		ad.setStud(stud);
		
		s.save(ad);
		s.save(stud);
		
		tx.commit();
		s.close();
		sf.close();
	}
}

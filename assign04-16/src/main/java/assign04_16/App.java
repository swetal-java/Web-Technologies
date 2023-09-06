package assign04_16;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
       SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       
       Reader reader1 = new Reader();
       reader1.setReaderId(1);
       reader1.setFname("java");
       reader1.setLname("hibernate");
       reader1.setEmail("java@gmail.com");
       
       Reader reader2 = new Reader();
       reader2.setReaderId(2);
       reader2.setFname("php");
       reader2.setLname("laravel");
       reader2.setEmail("php@gmail.com");
       
       Subscribe subscribe1 = new Subscribe();
       subscribe1.setName("j");
       subscribe1.setSubscriptionId(1);
       
       Subscribe subscribe2 = new Subscribe();
       subscribe2.setName("p");
       subscribe2.setSubscriptionId(2);
       
       Set<Reader> rset = new HashSet<Reader>();
       rset.add(reader1);
       rset.add(reader2);
       
       Set<Subscribe> sset = new HashSet<Subscribe>();
       sset.add(subscribe1);
       sset.add(subscribe2);
       
       reader1.setSubscriptionSet(sset);
       reader2.setSubscriptionSet(sset);
       
       subscribe1.setRenders(rset);
       subscribe2.setRenders(rset);
       
       session.save(reader1);
       session.save(reader2);
       session.save(subscribe1);
       session.save(subscribe2);
       
       tx.commit();
       session.close();
       sf.close();
    }
}

package assign04_15;

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
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Cart c1 = new Cart();
        c1.setName("My cart");
        c1.setTotal(0.0);
        
        Item i1 = new Item();
        i1.setItemidString("item1");
        i1.setItemtotal(10.0);
        i1.setQuantity(2);
        
        Item i2 = new Item();
        i2.setItemidString("item2");
        i2.setItemtotal(20.0);
        i2.setQuantity(1);
        
        Set<Item> set1 = new HashSet<Item>();
        set1.add(i1);
        set1.add(i2);
        
       c1.setItems(set1);
       i1.setCart(c1);
       i2.setCart(c1);
       
       session.save(c1);
       session.save(i1);
       session.save(i2);
        
        
        tx.commit();
        session.close();
        sf.close();
    }
}

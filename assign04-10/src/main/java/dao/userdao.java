package dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.usermodel;

public class userdao {
	
	public static void insertdata(usermodel um) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(um);
		tx.commit();
		session.close();
	}
	
	public static usermodel logindata(usermodel um) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from usermodel hb where hb.email=:email and hb.password=:password";
		Query q = session.createQuery(hql);
		q.setParameter("email", um.getEmail());
		q.setParameter("password", um.getPassword());
		List list = q.list();
		usermodel u = (usermodel)list.get(0);
		tx.commit();
		session.close();
		return u;
	}
	
	//get data by id
	public static usermodel getdatabyid(int id) {
		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		usermodel um = session.get(usermodel.class, id);
		tx.commit();
		sf.close();
		return um;
	}
	
	//update on basis of id
	public static void updateuser(usermodel um) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "update from usermodel hb set hb.fname=:fname,hb.lname=:lname,hb.email=:email,hb.gender=:gender,hb.contact=:contact where hb.id=: id";
		Query q = session.createQuery(hql);
		q.setParameter("fname", um.getFname());
		q.setParameter("lname", um.getLname());
		q.setParameter("email", um.getEmail());
		q.setParameter("gender", um.getGender());
		q.setParameter("contact", um.getContact());
		q.setParameter("id", um.getId());
		int result = q.executeUpdate();
		tx.commit();
		session.close();
	}

}

package com.ashish.hql2;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
    	
//    	StudentHQL s1 = new StudentHQL(1, "Ashish", 90);
//    	StudentHQL s2 = new StudentHQL(90, "Zac", 87);
//    	StudentHQL s3 = new StudentHQL(78, "Mark", 67);
//    	StudentHQL s4 = new StudentHQL(45, "Jack", 69);
//    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(StudentHQL.class);
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    	SessionFactory sf = config.buildSessionFactory(registry);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
//    	session.save(s1);
//    	session.save(s2);
//    	session.save(s3);
//    	session.save(s4);
    	
    	//Query query = session.createQuery("select rollNo, studentName, studentMarks from Student_HQL");
    	
    	Query query = session.createQuery("from Student_HQL");
    	query.setCacheable(true);
    	
    	 /**
    	 *  using getResultList() method
    	 * 		-> while using this method 
    	 * 	      use syntax "from table_name"
    	 * 
    	 * 		##to print the whole table
    	 */
    	
    	List<Object> resultList = query.getResultList();
    	
    	for (Object object : resultList) {
			System.out.println(object);
		}
    	
    	/**
    	 *  using list() method
    	 * 		-> while using this method mention 
    	 * 		  column names in HQL query
    	 * 
    	 * 		##to print specific mentioned columns
    	 */
    	
//    	List<Object[]> objs = (List<Object[]>) query.list();
//    	
//    	for (Object[] o : objs) {
//			System.out.println(o[0] + " " + o[1] + " " + o[2]);
//		}
    	
    	System.out.println("############### query cache session2 ###########");
    	
    	
    	session.getTransaction().commit();
    	
    	session.close();
    	
    	Session session2 = sf.openSession();
    	session2.beginTransaction();
    	
    	Query query2 = session2.createQuery("from Student_HQL");
    	query2.setCacheable(true);
    	
    	
    	List<Object> resultList2 = query2.getResultList();
    	
    	for (Object object : resultList2) {
			System.out.println(object);
		}
    	
    	
    	
    	session2.getTransaction().commit();
    	session2.close();
    	
    	sf.close();
        
        
    }
}

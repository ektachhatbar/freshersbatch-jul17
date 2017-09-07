package com.hibernate.HibernateCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate.HibernateCaching.Product;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	Configuration configuration=new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory=configuration.buildSessionFactory();
    	
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Product product=new Product("laptop",40000);
    	session.persist(product);
    	Product pr=session.get(Product.class, product.getId());
    	//session.evict(pr);
    	//Product pr1=session.get(Product.class, product.getId());
    	tx.commit();
    	session.close();
    	/*sessionFactory.getCache().evictEntity(Product.class,product.getId());
    	Thread.sleep(10000);
    	System.out.println("Sleep Over");*/
    	
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	
    	Product pr2=session.get(Product.class, product.getId());
    	pr2.setPrice(600000);
    	Product pr3=session.get(Product.class, product.getId());
    	tx.commit();
    	session.close();
    }
}

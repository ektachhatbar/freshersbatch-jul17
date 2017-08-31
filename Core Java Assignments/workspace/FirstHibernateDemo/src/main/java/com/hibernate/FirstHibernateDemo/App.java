package com.hibernate.FirstHibernateDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    	Configuration configuration=new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory=configuration.buildSessionFactory();
    	insert(sessionFactory);
    	//update(sessionFactory);
    	//getAll(sessionFactory);
    	//delete(sessionFactory);
    	//testLoadGet(sessionFactory);
    	//testUpdateVsMerge(sessionFactory);
    	
    	//insetRecordUsingSQL(sessionFactory);
    	sessionFactory.close();
    }
    public static void testLoadGet(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Product product=session.load(Product.class,22L);
    	Product product2=session.get(Product.class,22L);

    	session.close();
    	System.out.println("Entity 22 loaded");
    }
    public static void insert(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Product product=new Product("laptop",40000);
    	
    	session.save(product);
    	Product product2=new Product("desktop",2646723);
    	session.save(product2);
    	tx.commit();
    	session.close();
    	System.out.println("Inserted a Product");
    }
    public static void update(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Product product=session.load(Product.class,1L);
    	product.setPrice(50000);
    	tx.commit();
    	session.close();
    }
    public static void getAll(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query=session.createQuery("from Product");
    	List<Product> listOfProduct=query.list();
    	System.out.println("List of Products : "+listOfProduct);
    	session.close();
    }
    public static void delete(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Product product=session.load(Product.class,1L);
    	session.delete(product);
    	tx.commit();
    	session.close();
    	System.out.println("Product Deleted");
    }
    public static void testUpdateVsMerge(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Product product=session.get(Product.class,13L);
    	product.setPrice(50000);
    	tx.commit();
    	session.close();
    	System.out.println("Product Updated");
    	product.setPrice(60000);
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Product product2=session.get(Product.class,13L);
    	session.merge(product);
    	tx.commit();
    	session.close();
    }
    public static void insetRecordUsingSQL(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	SQLQuery sqlQuery=session.createSQLQuery("insert into product_master(p_id,name,cost)values(?,?,?)");
    	sqlQuery.setParameter(0, 23);
    	sqlQuery.setParameter(1, "Desktop");
    	sqlQuery.setParameter(2, 592910);
    	sqlQuery.executeUpdate();
    	
    	//List<Product> listOfProduct=sqlQuery.list();

    	System.out.println(" Inserted ");
    	session.close();
    }
}

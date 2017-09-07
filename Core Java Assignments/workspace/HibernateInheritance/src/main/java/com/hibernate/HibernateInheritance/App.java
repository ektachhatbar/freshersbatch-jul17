package com.hibernate.HibernateInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateInheritance.tablepersubclass.Bike;
import com.hibernate.HibernateInheritance.tablepersubclass.Car;
import com.hibernate.HibernateInheritance.tablepersubclass.Vehicle;

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
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Vehicle vehicle=new Vehicle("sadas", 123);
    	Bike bike=new Bike("Honda",20000,"Handle Steering");
    	Car car=new Car("Skoda",120000,"Steering Wheel");
    	session.persist(vehicle);
    	session.persist(bike);
    	session.persist(car);
    	tx.commit();
    	session.close();
    	sessionFactory.close();
    }
}

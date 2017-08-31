package com.hibernate.SecondHibernateDemo;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;




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
    	insertRecords(sessionFactory);
    	getAllEmployees(sessionFactory);
    	getTotalSalary(sessionFactory);
    	orderBySalary(sessionFactory);
    	groubByCity(sessionFactory);
    	getAvgSalary(sessionFactory);
    	getFilterSalary(sessionFactory);
    	
    	sessionFactory.close();
    }
    public static void getAllEmployees(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query = session.getNamedQuery("getAllEmployees");              
        List<Employee> listOfEmployee=query.list();
        System.out.println("List Of Employee(Named Query) : "+listOfEmployee);
    	session.close();
    }
    public static void insertRecords(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Employee emp1=new Employee("ABC","Pune",9000);
    	session.save(emp1);
    	Employee emp2=new Employee("DEF","NAGPUR",30000);
    	session.save(emp2);
    	Employee emp3=new Employee("GHI","MUMBAI",800);
    	session.save(emp3);
    	Employee emp4=new Employee("JKL","Delhi",1800);
    	session.save(emp4);
    	Employee emp5=new Employee("MNO","NAGPUR",28000);
    	session.save(emp5);
    	tx.commit();
    	session.close();
    	System.out.println("Employee Inserted");
    }
    public static void getTotalSalary(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query=session.createQuery("select sum(salary) from Employee");
    	List<Integer> totalSal=query.list();
    	System.out.println("Total Salary(HQL) : "+totalSal.get(0));
    	Criteria cr = session.createCriteria(Employee.class); 
    	cr.setProjection(Projections.sum("salary"));
    	List result=cr.list();
    	System.out.println("Total Salary(Criteria) : "+result);
    	session.close();
    }
    public static void orderBySalary(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query=session.createQuery("from Employee E order by E.salary DESC");
    	List<Employee> listOfEmployee=query.list();
    	System.out.println("List Of Employee(HQL) : "+listOfEmployee);
    	Criteria cr = session.createCriteria(Employee.class); 
    	cr.addOrder(Order.desc("salary")); 
    	List result=cr.list();
    	System.out.println("List Of Employee(Criteria) : "+result);
    	session.close();
    }
    public static void groubByCity(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query=session.createQuery("SELECT count(E.id) FROM Employee E GROUP BY E.city");
    	List<Employee> listOfEmployee=query.list();
    	System.out.println("List Of Employee(HQL) : "+listOfEmployee);
    	Criteria cr = session.createCriteria(Employee.class);
    	cr.setProjection(Projections.groupProperty("city")); 
    	List result=cr.list();
    	System.out.println("List Of Employee(Criteria) : "+result);
    	session.close();
    }
    public static void getAvgSalary(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query=session.createQuery("select avg(salary) from Employee");
    	List<Integer> totalSal=query.list();
    	System.out.println("Average Salary(HQL) : "+totalSal.get(0));
    	Criteria cr = session.createCriteria(Employee.class); 
    	cr.setProjection(Projections.avg("salary"));
    	List result=cr.list();
    	System.out.println("Average Salary(Criteria) : "+result);
    	session.close();
    }
    public static void getFilterSalary(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Query query=session.createQuery("select E.name from Employee E where E.salary>10000");
    	List<Employee> listOfEmployee=query.list();
    	System.out.println("Employee Salary >10000 : "+listOfEmployee);
    	Criteria cr = session.createCriteria(Employee.class); 
    	cr.add(Restrictions.gt("salary", 10000.00)); 
    	List result=cr.list();
    	System.out.println("Employee Salary >10000(Criteria) : "+result);
    	session.close();
    }
}

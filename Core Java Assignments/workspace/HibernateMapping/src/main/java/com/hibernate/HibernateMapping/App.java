package com.hibernate.HibernateMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateMapping.EmployeeManager.EmployeeManager;
import com.hibernate.HibernateMapping.manytomany.Course;
import com.hibernate.HibernateMapping.manytomany.Student;
import com.hibernate.HibernateMapping.onetomany.Answer;
import com.hibernate.HibernateMapping.onetomany.Question;
import com.hibernate.HibernateMapping.onetoone.Employee;
import com.hibernate.HibernateMapping.onetoone.Profile;

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
    	//oneToOne(sessionFactory);
    	//oneToMany(sessionFactory);
    	//manyToMany(sessionFactory);
    	employeeManager(sessionFactory);
    	sessionFactory.close();
    }
    public static void oneToOne(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Profile profile=new Profile("Xoriant", 5);
    	Employee emp=new Employee("John", 12345, profile);
    	session.persist(emp);
    	long e_id=emp.getEmployeeId();
    	tx.commit();
    	session.close();
    	
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Employee emp1=session.load(Employee.class, e_id);
    	emp1.setSal(679087);
    	emp1.getProfile().setExperience(9);
    	session.update(emp1);
    	tx.commit();
    	session.close();
    	
    	session=sessionFactory.openSession();
    	Query query=session.createQuery("from Employee");
    	List<Employee> listOfEmployee=query.list();
    	for(Employee e:listOfEmployee){
    		System.out.println(e);
    	}
    	session.close();
    	
    	
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Employee emp2=session.load(Employee.class, e_id);
    	session.delete(emp2);
    	tx.commit();
    	session.close();
    }
    
    public static void oneToMany(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Question qus=new Question("Which Countries are in Europe?");
    	Answer ans1=new Answer("Sweden",qus);
    	Answer ans2=new Answer("Germany",qus);
    	Answer ans3=new Answer("Italy",qus);
    	Answer ans4=new Answer("asa",qus);
    	Set<Answer> answers=new HashSet<Answer>();
    	answers.add(ans1);
    	answers.add(ans2);
    	answers.add(ans3);
    	qus.setAnswers(answers);
    	session.persist(qus);
    	long q_id=qus.getQusId();
    	tx.commit();
    	session.close();
    	
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Question que=session.load(Question.class, q_id);
    	que.setQusDesc("List of Countries in Europe");
    	//que.getAnswers().add(ans4);
    	session.update(que);
    	tx.commit();
    	session.close();
    	
    	session=sessionFactory.openSession();
    	Query query=session.createQuery("from Question");
    	List<Question> listOfQuestion=query.list();
    	for(Question q:listOfQuestion){
    		System.out.println(q);
    	}
    	session.close();
    	
    	
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Question que2=session.load(Question.class, q_id);
    	session.delete(que2);
    	tx.commit();
    	session.close();
    }
    public static void insertCourses(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	Student stud1=new Student("Tom");
    	Student stud2=new Student("Jerry");
    	Student stud3=new Student("Harry");
    	
    	Set<Student> java_stud=new HashSet<Student>();
    	java_stud.add(stud1);
    	java_stud.add(stud2);
    	Set<Student> hibernate_stud=new HashSet<Student>();
    	java_stud.add(stud2);
    	java_stud.add(stud3);
    	Set<Student> spring_stud=new HashSet<Student>();
    	java_stud.add(stud1);
    	java_stud.add(stud3);
    	
    	Course course_java=new Course("Java Programming",java_stud);
    	Course course_hibernate=new Course("Hibernate Programming",hibernate_stud);
    	Course course_spring=new Course("Spring Programming",spring_stud);
    	
    	session.persist(course_java);
    	session.persist(course_hibernate);
    	session.persist(course_spring);
    	tx.commit();
    	session.close();
    }
    public static void insertStudents(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Course course1=new Course("Java Programming");
    	Course course2=new Course("Hibernate Programming");
    	Course course3=new Course("Spring Programming");
    	
    	Set<Course> course_tom=new HashSet<Course>();
    	course_tom.add(course1);
    	Set<Course> course_jerry=new HashSet<Course>();
    	course_jerry.add(course2);
    	course_jerry.add(course3);
    	Set<Course> course_harry=new HashSet<Course>();
    	course_harry.add(course1);
    	course_harry.add(course2);
    	course_harry.add(course3);
    	
    	Student stud_tom=new Student("Tom", course_tom);
    	Student stud_jerry=new Student("Jerry", course_jerry);
    	Student stud_harry=new Student("Harry", course_harry);
    	
    	session.persist(stud_tom);
    	session.persist(stud_jerry);
    	session.persist(stud_harry);
    	
    	tx.commit();
    	session.close();
    }
    public static void manyToMany(SessionFactory sessionFactory){
    	insertCourses(sessionFactory);
    	insertStudents(sessionFactory);
    	
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Course course=session.load(Course.class, 1L);
    	course.setCourseName("PHP Programming");
    	session.update(course);
    	Student stud=session.load(Student.class, 2L);
    	stud.setStudentName("Sherlock");
    	session.update(stud);
    	tx.commit();
    	session.close();
    	
    	session=sessionFactory.openSession();
    	Query course1=session.createQuery("from Course");
    	List<Course> listOfCourse=course1.list();
    	for(Course c:listOfCourse){
    		System.out.println(c);
    	}
    	Query stud1=session.createQuery("from Student");
    	List<Student> listOfStudent=stud1.list();
    	for(Student s:listOfStudent){
    		System.out.println(s);
    	}
    	session.close();
    	
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Course course2=session.load(Course.class, 1L);
    	session.delete(course2);
    	/*Student stud2=session.load(Student.class, 7L);
    	session.delete(stud2);*/
    	tx.commit();
    	session.close();
    }
    public static void employeeManager(SessionFactory sessionFactory){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	EmployeeManager empM=new EmployeeManager("abc");
    	session.persist(empM);
    	EmployeeManager emp=new EmployeeManager("xyz",empM);
    	session.persist(emp);
    	EmployeeManager empp=new EmployeeManager("jkl",empM);
    	session.persist(empp);
    	tx.commit();
    	session.close();
    	session=sessionFactory.openSession();
    	tx=session.beginTransaction();
    	Query empMan=session.createQuery("from EmployeeManager where employee is not null");
    	List<EmployeeManager> listOfEmployeeManager=empMan.list();
    	for(EmployeeManager em:listOfEmployeeManager){
    		System.out.println(em);
    	}
    	session.close();
    }
    
}

/**
 * 
 */
package com.lnt.day18.hibernate.basicXml;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnt.day18.hibernate.emp.model.Employee;
import com.lnt.day18.hibernate.util.HibernateUtil;

/**
 * @author Smita B Kumar
 * C -> session.beginTransaction() -> session.save(obj) -> tx.commit()
 * R ->  session.get(ObjectClass.class,id) 
 * U -> session.beginTransaction() -> session.update(obj) -> tx.commit()
 * D -> session.beginTransaction() -> session.delete(obj) -> tx.commit()
 * S ->  session.createQuery("from ObjectClass").list() -> 
 */
/**
 * (hibernate.cfg.xml)SessionFactory->Session->(hbm.xml)methods->operate on DB
 * Transactions -> all statement executed as one (if 1 statement fails the none will execute)-
 * Transaction should be taken care only with DML operations(insert,update,delete)
 * SessionFactory->Session->HQL Query->operate on DB
 */
public class EmpXmlClient {	
	public static void main(String[] args) {
		Integer empId=new Integer((int) (1000+Math.random()*123*123));
		Employee employee = new Employee(empId, "Zara", 9999.99);
		// sessionFactory
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();//get the connection to the DB from the pool
		Transaction tx=session.beginTransaction();
		Integer id=(Integer) session.save(employee);//persisting the employee object into DB
		tx.commit();
		if (id>0)System.out.println("\nEmployee Saved!! with unique id : "+id);
		else System.err.println("\nEmployee NOT Saved!! ");
		
		System.out.println("\nListing all the Employees records ");
		//Hibernate Query Language (HQL) which focus on Object class not Table
		//focus on properties not column
		Query query = session.createQuery("from Employee");
		List<Employee > empList = query.list();
		if(empList!=null)		empList.forEach(System.out::println);//java 8 forEach method and method reference ::
		else System.err.println("\nNo Employee Records Found!!");
		
		System.out.println("\nUpdating the Employee records  ");
		employee.setEmpName("Zara Khan");
		employee.setEmpSal(11111.99);
		tx=session.beginTransaction();//as DML operation
		session.update(employee);
		tx.commit();//		

		System.out.println("\nSearching the Employee by Id ");
		Employee e1 =(Employee) session.get(Employee.class, empId);
		if (e1!=null)System.out.println("\nEmployee Found!! "+e1);
		else System.err.println("\nEmployee NOT Found!! with Id "+empId);//fetching the employee object from DB-
		
		System.out.println("\nDeleting the Employee by Id ");
		tx=session.beginTransaction();//as DML operation
		session.delete(employee);
		tx.commit();//		
		
		System.out.println("\nListing all the Employees records after delete");
		//Hibernate Query Language (HQL) which focus on Object class not Table
		//focus on properties not column
		query = session.createQuery("from Employee");
		empList = query.list();
		if(empList!=null)		empList.forEach(System.out::println);//java 8 forEach method and method reference ::
		else System.err.println("\nNo Employee Records Found!!");
		
		session.close();
		HibernateUtil.closeFactory();
	}

}

//Create a new Configuration ,
//for current application which has specific information about properties and
//mapping documents to be used
//With configure() API method use the mappings and properties specified in an
//application resource named hibernate.cfg.xml .

//if class is customer file name should be customer.hbm.xml... automatically
//configuration().configure() method takes data from this file

//creating session is lightweight process, multiple sessions can be created and
//no need to bother deallocation.

//buildSessionFactory(); method depricated in hibernate 4
//suggesting to use alternative ServiceRegistry object
/*
* private static SessionFactory sessionFactory; private static ServiceRegistry
* serviceRegistry; Configuration configuration = new Configuration();
* configuration.configure(); serviceRegistry = new
* ServiceRegistryBuilder().applySettings(configuration.getProperties()).
* buildServiceRegistry(); sessionFactory =
* configuration.buildSessionFactory(serviceRegistry);
* 
*/
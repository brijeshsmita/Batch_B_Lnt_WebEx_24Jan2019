/**
 * 
 */
package com.lnt.day19.hibernate.annotation;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnt.day19.hibernate.emp.model.Employee;
import com.lnt.day19.hibernate.util.HibernateUtil;

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
public class EmpAnnotationClient {	
	public static void main(String[] args) {
		Integer empId=new Integer((int) (1000+Math.random()*123*123));
		Employee employee = new Employee( "Reshma", 12345.99);
		// sessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//persist the employee Object
		System.out.println("\nTrying to persist the employee Object");
		empId=(Integer) session.save(employee);
		tx.commit();
		if(empId>0)System.out.println("\nEmployee Saved with unique id : "+empId);
		else System.err.println("\nEmployee Not Saved!!");
		
		
		//List all emp Object
		System.out.println("\nTrying to List the all employee Object");
		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();
		if(empList!=null)empList.forEach(emp->System.out.println(emp));//java 8 lamda + forEach
		else System.err.println("\nEmployees Not Found!!");
		
		//update the employee Object
		System.out.println("\nTrying to update the employee Object");
		tx = session.beginTransaction();
		employee.setEmpName("Reshma Garud");employee.setEmpSal(9999.99);
		session.update(employee);
		tx.commit();
		System.out.println("\nEmployee updated : "+employee);
		
		//searching the emp Object by id
		System.out.println("\nTrying to search employee Object");
		employee= (Employee) session.get(Employee.class, empId);
		if(employee!=null)System.out.println("\nEmployees  Found!! : "+employee);//java 8 lamda + forEach
		else System.err.println("\nEmployees Not Found!!");
		
		//delete the employee Object
		System.out.println("\nTrying to Delete the employee Object");
		tx = session.beginTransaction();
		session.delete(employee);
		tx.commit();
		System.out.println("\nEmployee Deleted : "+employee);
		
		//List all emp Object
		System.out.println("\nTrying to List the all employee Object");
		query = session.createQuery("FROM Employee");//in HQL ,syntax is case-insensitive but class name is case sensitive
		//FROM Employee ....is same as... select * from Employee_table
		
		empList = query.list();
		if(empList!=null)empList.forEach(emp->System.out.println(emp));//java 8 lamda + forEach
		else System.err.println("\nEmployees Not Found!!");
		
		//at last
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
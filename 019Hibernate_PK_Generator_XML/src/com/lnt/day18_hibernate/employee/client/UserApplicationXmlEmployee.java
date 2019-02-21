package com.lnt.day18_hibernate.employee.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lnt.day18_hibernate.employee.model.Employee;
public class UserApplicationXmlEmployee {
	public static void main(String[] args) {
		//Employee employee = new Employee("Riya", "Raj", "9998885555", "riya@gmail.com", new Date());
		Employee employee = new Employee("Smita", "Kumar", "9998887888", "smita@gmail.com", new Date());
		//Employee employee = new Employee("Diya", "Sen", "9998887770", "diya@gmail.com", new Date());
			// step 1 : create session Factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			// //step 2 : open session
			session = factory.openSession();
			// step 3 : In case of DML operations (Data manipulation insert
			// update and delete)
			// then begin transactions
			transaction = session.beginTransaction();
			// step 4 : saving the employee -insert/create
			Long id = (long) session.save(employee);
			System.out.println(" Employee record inserted with Id : " + id);
			// step 5 : committing transaction
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (factory != null)
				factory.close();
		}
	}
}

// Create a new Configuration ,
// for current application which has specific information about properties and
// mapping documents to be used
// With configure() API method use the mappings and properties specified in an
// application resource named hibernate.cfg.xml .

// if class is employee file name should be employee.hbm.xml... automatically
// configuration().configure() method takes data from this file

// creating session is lightweight process, multiple sessions can be created and
// no need to bother deallocation.

// buildSessionFactory(); method depricated in hibernate 4
// suggesting to use alternative ServiceRegistry object
/*
 * private static SessionFactory sessionFactory; private static ServiceRegistry
 * serviceRegistry; Configuration configuration = new Configuration();
 * configuration.configure(); serviceRegistry = new
 * ServiceRegistryBuilder().applySettings(configuration.getProperties()).
 * buildServiceRegistry(); sessionFactory =
 * configuration.buildSessionFactory(serviceRegistry);
 * 
 */

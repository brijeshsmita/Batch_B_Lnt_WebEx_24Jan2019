package com.lnt.day18_hibernate.customer.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.lnt.day18_hibernate.customer.model.Customer;

public class UserApplicationAnnotation {

	public static void main(String[] args) {

		 Customer customer = new Customer("Shiv", "shiv@g.com", "9879879666");
		//Customer customer = new Customer("Sia", "sia@g.com", "9879879876");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// step 1 : session Factory
		Session session = null;

		Transaction transaction = null;
		try {// step 2 : opening session
			session = factory.openSession();
			// step 3 : Beginning transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert
			Long id = (Long) session.save(customer);
			System.out.println("inserted Customer: " + id);// commiting						// transaction			
			// step 5: commiting the tx
			transaction.commit();
			Customer cust= (Customer) session.get(Customer.class, new Long(9));//get the customer id 9
			//nor lets update the 7th record 
			cust.setCustName("Shivansh");cust.setEmail("Shivansh@gmail.com");cust.setPhone("7878787878");
			//updating the customer
			transaction = session.beginTransaction();
			session.update(customer);	
			transaction.commit();
			System.out.println("Updated Customer: " + (Customer) session.get(Customer.class, new Long(9)));
			System.out.println("************the List of all the Customer************");
			List<Customer> custList=session.createQuery("from Customer").list();
			for(Customer c: custList)
				System.out.println(c);
				
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if(session!=null)
				session.close();
			if (factory != null)
				factory.close();
		}

	}

}

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

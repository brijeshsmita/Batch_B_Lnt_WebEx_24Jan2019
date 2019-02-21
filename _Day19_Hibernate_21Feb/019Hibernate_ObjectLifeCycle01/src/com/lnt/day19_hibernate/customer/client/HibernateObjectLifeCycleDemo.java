package com.lnt.day19_hibernate.customer.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.lnt.day19_hibernate.customer.model.Customer;

public class HibernateObjectLifeCycleDemo {

	public static void main(String[] args) {

		// Customer customer = new Customer(1111, "Shiv", "shiv@g.com",
		// "9879879666");
		// created a customer object
		/*
		 * 1) Transient State- When ever an object of a pojo class is created
		 * then it will be in the Transient state. One newly created object,
		 * without having any relation with the database, means never
		 * persistent, not associated with any Session object.
		 */
		Customer customer = new Customer("SmitaKumar", "smitakumar@g.com", "9879879876");
		// Customer is in Transient state, as it is not associated with db or session object

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// step 1 : session Factory
		Session session = null;
//session object is simply a connection with the database - and SessionFactory will provide the session(connection)

		Transaction transaction = null;
		try {// step 2 : opening session
			session = factory.openSession();//opening the connection
			// step 3 : Beginning transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert
			Long id = (Long) session.save(customer);// Hibernate Object enters
													// Persistence state
			/*
			 * 2) Persistent State- Having the relation with the database,
			 * associated with a unique Session object save() , saveOrUpdate(),
			 * persist()
			 */
			System.out.println("inserted Customer: " + id);// commiting
															// transaction
			// step 5: commiting the tx
			transaction.commit();
			Thread.sleep(10000);
			session.close();// Closing the session
			/*
			 * Now my persistent object state is detached when we hit
			 * clear(),close() or evit() method 3) Detached- previously having
			 * relation with the database [persistent ], now not associated with
			 * any Session.
			 */
			session = factory.openSession();
			customer.setPhone("9123123999");// updating customer object phoneNo
			// now we will update it on database
			transaction = session.beginTransaction();// we will always begin tx
														// for DML operation
			System.out.println("updating Customer phoneNo with id : " + id);
			session.update(customer);
			// Now my detached object state is again into persistent state when
			// we hit update(),merge() or saveOrUpdate() method
			// commit tx
			transaction.commit();
			System.out.println("updated Customer: " + customer);

			// now we will delete the object from the database
			transaction = session.beginTransaction();// we will always begin tx
														// for DML operation()
			System.out.println("Deleting Customer with id : " + id);
			session.delete(customer);// removed state
			// Now my object is in removed state when we hit delete() method
			/*
			 * 4) Removed- A persistent object is considered to be in the
			 * removed state when a delete() operation is called on it. Note
			 * that Once you've deleted .an object and moved to the “removed”
			 * state, you should no longer use that particular object for any
			 * reason.
			 */
			Thread.sleep(10000);

			// commit tx
			transaction.commit();
			System.out.println("Deleted Customer with id : " + id);

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

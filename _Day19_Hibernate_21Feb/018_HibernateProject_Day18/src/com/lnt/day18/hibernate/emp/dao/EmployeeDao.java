/**
 * 
 */
package com.lnt.day18.hibernate.emp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnt.day18.hibernate.emp.exception.EmployeeException;
import com.lnt.day18.hibernate.emp.model.Employee;
import com.lnt.day18.hibernate.util.HibernateUtil;

/**
 * @author Smita
 *
 */
public class EmployeeDao implements IEmployeeDao {

	/**
	 * prepwork -> SessionFactory Object
	 */
	//private static Connection conn;
	private static SessionFactory sessionFactory;
	private static Session session;
	private Transaction tx;
	static {
		sessionFactory=HibernateUtil.getSessionFactory();
		if(sessionFactory!=null) {
			System.out.println("sessionFactory Obtained!!"+sessionFactory);			
		}else {
			System.err.println("sessionFactory NOT Obtained!!"+sessionFactory);
		}
	}

	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		Integer empId=(Integer) session.save(employee);
		tx.commit();
		session.close();
		return empId;
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listAllEmployee() throws EmployeeException {
		session=sessionFactory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		session.close();
		return empList;
	}
	@Override
	public int updateEmployee(Employee employee) throws EmployeeException {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
		return 1;
	}
	@Override
	public int deleteEmployee(int empId) throws EmployeeException {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.delete(searchEmployeeById(empId));
		tx.commit();
		session.close();
		return 1;		
	}

	@Override
	public Employee searchEmployeeById(int empId) throws EmployeeException {
		session=sessionFactory.openSession();
		Employee emp=(Employee) session.get(Employee.class, empId);//get return Object thus need to be typecasted
		session.close();
		return emp;
	}
}

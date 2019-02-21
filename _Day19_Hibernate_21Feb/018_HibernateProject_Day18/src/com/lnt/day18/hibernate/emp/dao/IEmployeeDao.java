/**
 * 
 */
package com.lnt.day18.hibernate.emp.dao;

import java.util.List;

import com.lnt.day18.hibernate.emp.exception.EmployeeException;
import com.lnt.day18.hibernate.emp.model.Employee;

/**
 * @author Smita
 *
 */
//DAO- Data access layer , which is responsible to interact with database only
//restaurant - chef ( which takes care of data i.e food)
public interface IEmployeeDao {
	public int addEmployee(Employee employee)throws EmployeeException;//C
	public List<Employee> listAllEmployee()throws EmployeeException;//R
	public int updateEmployee(Employee employee)throws EmployeeException;//U
	public int deleteEmployee(int empId)throws EmployeeException;//D
	public Employee searchEmployeeById(int empId)throws EmployeeException;//S
	
}

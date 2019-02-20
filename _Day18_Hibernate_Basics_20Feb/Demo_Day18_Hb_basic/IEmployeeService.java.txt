/**
 * 
 */
package com.lnt.day18.hibernate.emp.service;

import java.util.List;

import com.lnt.day18.hibernate.emp.exception.EmployeeException;
import com.lnt.day18.hibernate.emp.model.Employee;

/**
 * @author Smita B Kumar
 *
 */
public interface IEmployeeService {
	public int addEmployee(Employee employee)throws EmployeeException;//C
	public List<Employee> listAllEmployee()throws EmployeeException;//R
	public int updateEmployee(Employee employee)throws EmployeeException;//U
	public int deleteEmployee(int empId)throws EmployeeException;//D
	public Employee searchEmployeeById(int empId)throws EmployeeException;//S
}

/**
 * 
 */
package com.lnt.day19.hibernate.emp.service;

import java.util.List;

import com.lnt.day19.hibernate.emp.dao.EmployeeDao;
import com.lnt.day19.hibernate.emp.dao.IEmployeeDao;
import com.lnt.day19.hibernate.emp.exception.EmployeeException;
import com.lnt.day19.hibernate.emp.model.Employee;

/**
 * @author Smita B Kumar
 *
 */
public class EmployeeService implements IEmployeeService {

	/**
	 * prepwork -> EmployeeDao Object - to call Dao layer method from service layer
	 */
	private IEmployeeDao employeeDao;
	public EmployeeService() {
		employeeDao= new EmployeeDao();
	}
	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employee);
	}
	@Override
	public List<Employee> listAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.listAllEmployee();
	}
	@Override
	public int updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}
	@Override
	public int deleteEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(empId);
	}
	@Override
	public Employee searchEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.searchEmployeeById(empId);
	}

}

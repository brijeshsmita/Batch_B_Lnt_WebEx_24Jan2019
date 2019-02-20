/**
 * 
 */
package com.lnt.day18.hibernate.emp.model;
import java.io.Serializable;
/** * @author Smita 
 * CREATE TABLE EMP123(EID NUMBER PRIMARY KEY, ENAME VARCHAR2(30),ESAL NUMBER);
create sequence emp123_seq start with 1;* */
public class Employee implements Serializable{
	private Integer empId;
	private String empName;
	private Double empSal;
	// constructors,getters and setters,toSTring(), equals(),hashCode()
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, Double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}

	public Employee(Integer empId, String empName, Double empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

}

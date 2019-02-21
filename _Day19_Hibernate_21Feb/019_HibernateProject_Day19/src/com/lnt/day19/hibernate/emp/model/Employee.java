/**
 * 
 */
package com.lnt.day19.hibernate.emp.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/** * @author Smita 
 * CREATE TABLE EMP123_hb1(EID NUMBER PRIMARY KEY, ENAME VARCHAR2(30),ESAL NUMBER);
create sequence emp123_seq_hb1 start with 1;* */
//persistence class ,this class properties value will be persisted in the  associated database table coumn 
@Entity //MAPPING THE CLASS WITH THE TABLE - table name is not mentioned then by default the class name will be the table name
@Table(name="EMP123_hb1")//@table- used to provide the mapping table name
public class Employee implements Serializable{
	private static final long serialVersionUID = -5139958328281427103L;
	//Id annotation is used to map primary key column
	@Id
	@GeneratedValue(generator="emp_gen",strategy=GenerationType.SEQUENCE)//sequence will be providing the Primary key value
	@SequenceGenerator(name="emp_gen",sequenceName="emp123_seq_hb1",allocationSize=1)	
	@Column(name="emp_id")
	private Integer empId;//if column name is not specified then the coumn name will be same name of the property name
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_sal")
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

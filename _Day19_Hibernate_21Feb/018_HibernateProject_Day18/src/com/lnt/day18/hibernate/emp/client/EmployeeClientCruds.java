/**
 * 
 */
package com.lnt.day18.hibernate.emp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.lnt.day18.hibernate.emp.exception.EmployeeException;
import com.lnt.day18.hibernate.emp.model.Employee;
import com.lnt.day18.hibernate.emp.service.EmployeeService;
import com.lnt.day18.hibernate.emp.service.IEmployeeService;

/**
 * @author Smita B Kumar
 *
 */
public class EmployeeClientCruds {
	/**
	 * prep work -> object of IEmployeeService
	 */
	private static IEmployeeService employeeService = new EmployeeService();
	public static void main(String[] args) {
	 int result=0;
	 int choice =0;
	 try( Scanner sc = new Scanner(System.in) ;
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
		 Employee employee =new Employee();
		 while(true) {
			 System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
			 		+ "\nEnter Your choice from 1 - 6 ... 6 to exit ...only Numeric value"
			 		+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
			 		+ "\n 			1. Add Employeee"
			 		+ "\n 			2. List Employeee"
			 		+ "\n 			3. Update Employeee"
			 		+ "\n 			4. Delete Employeee"
			 		+ "\n 			5. Search Employeee"
			 		+ "\n 			6. Exit Employeee App"
			 		+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			 choice=sc.nextInt();
			 switch (choice) {
				case 1:
					System.out.println("Adding Employee Record!!");
					System.out.println("Enter Employee Id ");
					 int eId=sc.nextInt();
					 System.out.println("Enter Employee Name ");
					 String empName=br.readLine();
					 System.out.println("Enter Employee Salary ");
					 double empSal=sc.nextDouble();
					employee.setEmpId(eId);
					employee.setEmpName(empName);
					employee.setEmpSal(empSal);
					 int autoEmpId =employeeService.addEmployee(employee);
					if(autoEmpId>1)System.out.println("Employee Record Added... with the unique Id : "+autoEmpId);
					else System.err.println("Employee Record NOT Added");
						
					break;
				case 2:
					System.out.println("Listing Employee Record!!");
					List<Employee> empList =employeeService.listAllEmployee();
					if(empList!=null) {
						for(Employee e : empList) System.out.println(e);
					}
					else System.err.println("Record Not Found");
					break;
				case 3:
					System.out.println("Updating Employee Record!!");
					System.out.println("Enter Employee Id to be Updated....");
					int eid=sc.nextInt();
					System.out.println("Enter name to be updataed");
					String newName=br.readLine();
					System.out.println("Enter salary to be updataed");
					double newSal=sc.nextDouble();
					employee.setEmpId(eid);
					employee.setEmpName(newName);
					employee.setEmpSal(newSal);
					result =employeeService.updateEmployee(employee);
					if(result==1)System.out.println("Employee Record Updated");
					else System.err.println("Employee Record NOT Updated");
					break;
				case 4:
					System.out.println("Deleting Employee Record!!");
					System.out.println("Enter Employee Id to be deleted....");
					eid=sc.nextInt();
					result =employeeService.deleteEmployee(eid);
					if(result==1)System.out.println("Employee Record Deteletd");
					else System.err.println("Employee Record NOT Deteletd");
					break;
				case 5:
					System.out.println("Searching Employee Record!!");
					System.out.println("Enter Employee Id to be searched....");
					int id=sc.nextInt();
					employee =employeeService.searchEmployeeById(id);
					if(employee!=null) System.out.println(employee);
					else System.out.println("Record Not Found");
					break;
				case 6:
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
							+ "Thank you for using our Employee Application ......Exiting Employee App!!"
							+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					System.exit(0);//to terminate the program
					break;
				default:
					System.err.println("Sorry You have enyered wrong choice...");
					break;
				}//end of switch
			}//end of while
		 }catch (EmployeeException e) {
			System.err.println(e);
		} catch (IOException e1) {
			System.err.println(e1);
		}
	}//end of main
}

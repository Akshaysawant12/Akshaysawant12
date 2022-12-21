package main;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import Db.DBConnection;
import EmployeeDb.EmployeeEmp;
import EmployeeDb.EmployeeEmpInterface;
import model.Employee;
public class Client
{
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	DBConnection db=new DBConnection();

	DBConnection.createConnection();
   db.CreateTable();
  
   
    Scanner sc=new Scanner(System.in);
    

    EmployeeEmpInterface emp=new EmployeeEmp();
    System.out.println("-***---**---Welcome to Employee Management application--**---***-");
    
    System.out.println("\n1.Admin login");
    
    	 System.out.println("Enter choice");
    	    int u=sc.nextInt();
    	  
    		 	    
    if(u==1) {
    String adminlogin="Akshay";
    String adminpassword="Akshay123";
    System.out.println("Enter username");
   String adminlogin1=sc.next();
    System.out.println("Enter password");
    String adminpassword1=sc.next();
    
    
    if(adminlogin.equals(adminlogin1) || adminpassword.equals(adminpassword1))
    {
   System.out.println("login successfully !");
    }
    else {
    	System.out.println("invalid id or password");
    }
    
    
  while(adminlogin.equals(adminlogin1)&& adminpassword.equals(adminpassword1)) {
   
    

        System.out.println("\n1.Add new Employee" +
                "\n2.Show All Employee" +
                "\n3.show Employee based on empId+" +
                "\n4.Delete Employee"+
                "\n5.Update Employee" +
                "\n6.Exit");
        
        System.out.println("Enter choice");
        int ch=sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("Add new Employee");
                System.out.println("Enter empId");
                int  empId=sc.nextInt();
                System.out.println("Enter employee first name");
                String Fname=sc.next();
                System.out.println("Enter employee last name");
                String Lname=sc.next();
                System.out.println("Enter a email");
                String email=sc.next();
                System.out.println("Enter Department name");
                String Department=sc.next();
                System.out.println("Enter desiganation");
                String desiganation=sc.next();
                System.out.println("Enter Salary");
                double Salary=sc.nextDouble();
                
                Employee e=new Employee(empId,Fname,Lname,email,Department , desiganation,Salary);
                emp.insertEmployee(e);
               

                break;
                
            case 2:
                System.out.println("Show all Employee ");
                System.out.println("All Employee List in our System");
                emp.showAllEmployee();

                break;
            case 3:
                System.out.println("show Employee based on EmployeeId");
                System.out.println("Enter Employee ID");
                empId=sc.nextInt();
               emp.showEmployeeById(empId);
              

                break;
            case 4:
                System.out.println("Delete employee");
                System.out.println("enter empId number to delete");
                 empId=sc.nextInt();
                emp.delete(empId);
               
                
                break;
            case 5:
                System.out.println("\n1.Update the Employee");
                System.out.println("\n2.Update Salary");
                System.out.println("enter your choice");
                int choice=sc.nextInt();
                if(choice==1){
                    System.out.println("enter  a employee Id");
                     empId=sc.nextInt();
                    System.out.println("Enter new Salary");
                    Salary=sc.nextDouble();
                    Employee std=new Employee();
                    std.setSalary(Salary);
                  emp.update(empId,Salary,choice,std);
                              
         
}
                break;
            case 6:
                System.out.println("Thank You for using Employee management application!!!");
                System.exit(0);
            default:
                System.out.println("Please enter valid choice..");
        
       
}    
    
}
}
}
    
}




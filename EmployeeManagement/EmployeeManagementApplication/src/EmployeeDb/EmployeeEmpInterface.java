package EmployeeDb;

import model.Employee;

public interface EmployeeEmpInterface {
	  public void  insertEmployee(Employee s);
	    public void delete(int empId);
	    public void  update(int empId,Double Salary,int ch,Employee s);
	    public void showAllEmployee();
	    public void  showEmployeeById(int empId);
	   
	
	
	}


package EmployeeDb;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DBConnection;
import model.Employee;

public  class EmployeeEmp implements EmployeeEmpInterface{

    @Override
    public void  insertEmployee(Employee s) {
       
        try{
            Connection con= DBConnection.createConnection();
             
            String query="insert into employee( empId,Fname,Lname,Email,Department,Designation,Salary) value(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setInt(1, s.getEmpId());
            pst.setString(2,s.getFname());
            pst.setString(3,s.getLname());
            pst.setString(4,s.getEmail());
           
            pst.setString(5,s.getDepartment());
            pst.setString(6,s.getDesiganation());
            pst.setDouble(7,s.getSalary());
          
           int cnt= pst.executeUpdate();
           if(cnt!=0) {
        	   System.out.println("Employee inserted successfully !");
           }
        
     }
        catch(SQLException e) {
        	System.out.println("Employee with this Id already present in System");
        }
   
        catch(InputMismatchException e) {
        	System.out.println("Enter numeric value");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        
        
    }

    

	@Override
    public void delete(int empId) {
       
        try{
            Connection con=DBConnection.createConnection();
            String query="delete from employee where empId="+empId;
            PreparedStatement pst=con.prepareStatement(query);
           int cnt= pst.executeUpdate();
           if(cnt==empId) {
        	   System.out.println("Employee delete successfully !");
        	   
           }
           else {
        	   System.out.println("employee with this id is not present in System");
           }
        }
           catch(InputMismatchException e) {
           	System.out.println("Enter numeric value");
           }            

        
        catch (Exception e){
            e.printStackTrace();
        }
        
	}

    @Override
    public void  update(int empId, Double Salary, int ch,Employee s) {
        int choice=ch;
       
        try{
            if(choice==1){
                Connection con=DBConnection.createConnection();
                String query="update employee set Salary=? where empId=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setDouble(1,Salary);
                ps.setInt(2,empId);
                int cnt=ps.executeUpdate();
                if(cnt!=0)
                    System.out.println("Employee Details updated successfully !!"); 
                

            }
        }
            catch(InputMismatchException e) {
               	System.out.println("Enter numeric value");
               }

        catch (Exception ex){
            ex.printStackTrace();
        }
        
    }

    @Override
    public void showAllEmployee() {
        try{
            Connection con=DBConnection.createConnection();
            String query="select * from employee";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("empId: "+rs.getInt(1)+"\n" +
                        "Fname: "+rs.getString(2)+"\n" +
                        "Lname: "+rs.getString(3)+"\n" +
                        "email: "+rs.getString(4)+"\n" +
                        "Department: "+rs.getString(5)+"\n" +
                        "Designation: "+rs.getString(6)+"\n" +
                        "Salary: "+rs.getDouble(7));
                System.out.println("----------------------------------");

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void  showEmployeeById(int empId) {
       
        try{

            Connection con=DBConnection.createConnection();
            String query="select * from employee where empId="+empId;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("empId: "+rs.getInt(1)+"\n" +
                        "Fname: "+rs.getString(2)+"\n" +
                        "Lname: "+rs.getString(3)+"\n" +
                        "email: "+rs.getString(4)+"\n" +
                        "Department: "+rs.getString(5)+"\n" +
                        "Designation: "+rs.getString(6)+"\n" +
                        "Salary:      "+rs.getDouble(7));
                //System.out.println("----------------------------------");
              

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
      
       }
		
	

		
	

package Db;

import java.sql.*;

public class DBConnection {
	

		
	

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
	
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeempdb","root","");
		Statement st=con.createStatement();
		//String query="create database employeeempdb";
		//st.executeUpdate(query);
		return con;
		
	}

	
	public void CreateTable() throws SQLException, ClassNotFoundException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeempdb","root","");
		Statement st=con.createStatement();
		//String sqlquery="create table employee"+"(empId integer not null,"+"Fname varchar(20),"+"Lname varchar(20),"+"email varchar(20),"+"Department varchar(20),"+"Designation varchar(20),"+"Salary double not null,"+" primary key(empId))";
		//st.executeUpdate(sqlquery);
	}
}



	
	
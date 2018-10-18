package com.cg.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE" ;
	String user = "hr";
	String pass = "hr";
	Connection con = null;
	PreparedStatement ps = null;
	
	public void EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	
		
		
		
	public void s_ID(String str)
	{
		EmpDAO();
		String sql = "select * from employee where emp_id like '?'";
		
		try
		{
			ps = con.prepareStatement(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
		
		
		
		
		
}

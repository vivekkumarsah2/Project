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
	
	public void EmpCon()
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
		
	public void search(String field, String pattern)
	{
		EmpCon();
		String sql = "select * from employee where ? like '?'";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, field);
			ps.setString(2, pattern);		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

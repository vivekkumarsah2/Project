package com.cg.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
	public void searchID(String pattern)
	{
		EmpCon();
		String sql = "select * from employee where Emp_ID like ?";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, pattern);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("The selected employees are : \n");

			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getDate(5) + "\t" + rs.getInt(6) + "\t");
				System.out.print(rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9) +"\t" + rs.getString(10) + "\t" + rs.getString(11) + "\t" + rs.getString(12) + "\t" + rs.getString(13) +  "\n");
			
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void searchFName(String pattern)
	{
		EmpCon();
		String sql = "select * from employee where Emp_first_name like ?";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, pattern);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("The selected employees are : \n");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getDate(5) + "\t" + rs.getInt(6) + "\t");
				System.out.print(rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9) +"\t" + rs.getString(10) + "\t" + rs.getString(11) + "\t" + rs.getString(12) + "\t" + rs.getString(13) +  "\n");
			
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void searchLName(String pattern)
	{
		EmpCon();
		String sql = "select * from employee where Emp_last_name like ?";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, pattern);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("The selected employees are : \n");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getDate(5) + "\t" + rs.getInt(6) + "\t");
				System.out.print(rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9) +"\t" + rs.getString(10) + "\t" + rs.getString(11) + "\t" + rs.getString(12) + "\t" + rs.getString(13) +  "\n");
			
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void searchDept(String pattern)
	{
		EmpCon();
		String sql = "select * from employee where Emp_Dept_ID like ?";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, pattern);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("The selected employees are : \n");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getDate(5) + "\t" + rs.getInt(6) + "\t");
				System.out.print(rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9) +"\t" + rs.getString(10) + "\t" + rs.getString(11) + "\t" + rs.getString(12) + "\t" + rs.getString(13) +  "\n");
			
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void searchGrade(String pattern)
	{
		EmpCon();
		String sql = "select * from employee where Emp_Grade like ?";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, pattern);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("The selected employees are : \n");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getDate(5) + "\t" + rs.getInt(6) + "\t");
				System.out.print(rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9) +"\t" + rs.getString(10) + "\t" + rs.getString(11) + "\t" + rs.getString(12) + "\t" + rs.getString(13) +  "\n");
			
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void searchMS(String pattern)
	{
		EmpCon();
		String sql = "select * from employee where Emp_Marital_Status like ?";
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, pattern);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("The selected employees are : \n");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getDate(5) + "\t" + rs.getInt(6) + "\t");
				System.out.print(rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9) +"\t" + rs.getString(10) + "\t" + rs.getString(11) + "\t" + rs.getString(12) + "\t" + rs.getString(13) +  "\n");
			
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
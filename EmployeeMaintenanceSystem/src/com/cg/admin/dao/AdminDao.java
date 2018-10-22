package com.cg.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.employee.bean.Employee;

public class AdminDao
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE" ;
	String user = "hr";
	String pass = "hr";
	Connection con = null;
	PreparedStatement ps = null;
	
	public void AdmCon()
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

	public void add(Employee e) 
	{
		AdmCon();
		String sql = "Insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getEId());
			ps.setString(2, e.getEFName());	
			ps.setString(3, e.getELName());
			ps.setDate(4, new java.sql.Date(e.getDOB().getTime()));
			ps.setDate(5, new java.sql.Date(e.getDOJ().getTime()));
			ps.setInt(6, e.getDeptId());
			ps.setString(7, e.getEGrade());
			ps.setString(8, e.getEDesignation());
			ps.setInt(9, e.getEBasic());
			ps.setString(10, e.getEGender());
			ps.setString(11, e.getEMaritalStatus());
			ps.setString(12, e.getEAddress());
			ps.setString(13, e.getEContact());
			ps.executeQuery();
			
		}
		catch (SQLException E)
		{
			E.printStackTrace();
		}
	}
	public void modify(String id,String field, String mod)
	{
		AdmCon();
		String sql = "Update Employee set ? = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, field);
			ps.setString(2, mod);
			ps.setString(3, id);
			ps.executeUpdate();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyInt(String id, String field, int mod)
	{
		AdmCon();
		String sql = "Update Employee set ? = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, field);
			ps.setInt(2, mod);
			ps.setString(3, id);
			ps.executeUpdate();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}
	
	
}

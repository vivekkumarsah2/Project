package com.cg.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.admin.ui.AdminUI;
import com.cg.employee.ui.EmployeeUI;

public class AuthenticationService implements IAuthenticationService
{
	static Logger Log=Logger.getLogger(AuthenticationService.class.getName());
	
	public boolean Authenticate(String uid, String uname, String upassword)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE" ;
		String user = "hr";
		String pass = "hr";
		Connection con = null;
		try
		{
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		String sql = "select usertype from user_master where userid=? and username=? and userpassword=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			ps.setString(1, uid);
		} catch (SQLException e) {
			Log.error("Invalid ID");
			
		}
		try {
			ps.setString(2, uname);
		} catch (SQLException e) {
			Log.error("Invalid Name");
			
		}
		try {
			ps.setString(3, upassword);
		} catch (SQLException e) {
			Log.error("Invalid password");
			
		}
		
		ResultSet rs = null;
		try
		{
			rs = ps.executeQuery();
			
		}
		catch(Exception e)
		{
			Log.error("Please Try again");
			//Authenticate(uid, uname, upassword);
			
			return false;
		}
		
		
		String res = null;
		
		try 
		{
			while(rs.next())
			{
				res = rs.getString(1);
			}
			
			if(res.equalsIgnoreCase("admin")){
				AdminUI aui = new AdminUI();
				aui.admin();
				return true;
			}
			
			else if(res.equalsIgnoreCase("employee")){
				EmployeeUI eui = new EmployeeUI();
				eui.employee();
				return true;
			}
			else
				return false;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}

package com.cg.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import org.apache.log4j.Logger;
import com.cg.admin.ui.AdminUI;
import com.cg.employee.ui.EmployeeUI;

public class AuthenticationService implements IAuthenticationService
{
//	static Logger Log=Logger.getLogger(AuthenticationService.class.getName());
	
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
			
			ps.setString(1, uid);
			ps.setString(2, uname);
			ps.setString(3, upassword);
			
			ResultSet rs = ps.executeQuery();

			String res = null;
			while(rs.next())
			{
				res = rs.getString(1);
			}
			if(res.equalsIgnoreCase("admin"))
			{
				AdminUI aui = new AdminUI();
				aui.admin();
				con.close();
				return true;
			}
			
			else if(res.equalsIgnoreCase("employee"))
			{
				EmployeeUI eui = new EmployeeUI();
				eui.employee();
				con.close();
				return true;
			}
			else
			{
				con.close();
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Please Try again");
			return false;
		}
	}
}

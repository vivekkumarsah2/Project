package com.cg.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			con.close();
		}
		catch (SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyFname(String mod , String id) 
	{
		AdmCon();
		String sql = "Update Employee set Emp_First_Name = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyLname(String mod, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Last_Name = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyDept(int modint, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Dept_ID = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, modint);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyGrade(String mod, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Grade = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyDsgn(String mod, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Designation = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyBasic(int modint, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Basic = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, modint);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyMS(String mod, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Marital_Status = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyAddress(String mod, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Home_Address= ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}

	public void modifyContact(String mod, String id)
	{
		AdmCon();
		String sql = "Update Employee set Emp_Contact_num = ? where emp_id = ? ";
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mod);
			ps.setString(2, id);
			ps.executeUpdate();
			
			con.close();
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
	}
	
	public void display()
	{
		AdmCon();
		String sql = "Select e.Emp_Id, e.Emp_First_Name, e.Emp_Last_Name, d.Dept_Name, e.Emp_Designation, e.Emp_Grade from Employee e, Department d where e.Emp_Dept_Id = d.Dept_Id ";
		try
		{
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getString("Emp_Id") + "\t\t" + rs.getString("Emp_First_Name") + "\t\t" +  rs.getString("Emp_Last_Name") + "\t\t" );
				System.out.print(rs.getString("Dept_Name") +  "\t\t" + rs.getString("Emp_Designation") + "\t\t"  + rs.getString("Emp_Grade") + "\n");	
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

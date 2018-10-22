package com.cg.employee.service;

import java.util.Scanner;
import com.cg.employee.dao.EmployeeDao;

public class EmployeeService
{
	Scanner sc = new Scanner(System.in);
	  
	public void searchID()
	{
		EmployeeDao edao = new EmployeeDao(); 
		System.out.println("Enter Search ID");
		String id = sc.next();
		id = id.replace("?", "_");
		id = id.replace("*", "%");
		System.out.println(id);
		edao.searchID(id);
	}

	public void searchFName()
	{
		EmployeeDao edao = new EmployeeDao(); 
		System.out.println("Enter First Name");
		String id = sc.next();
		id = id.replace('?', '_');
		id = id.replace('*', '%');
		edao.searchFName(id);
	}

	public void searchLName()
	{
		EmployeeDao edao = new EmployeeDao(); 
		System.out.println("Enter Last Name");
		String id = sc.next();
		id = id.replace('?', '_');
		id = id.replace('*', '%');
		edao.searchLName( id);
	}

	public void searchDepartment()
	{
		EmployeeDao edao = new EmployeeDao(); 
		System.out.println("Enter Department id");
		String id = sc.next();
		edao.searchDept(id);
	}

	public void searchGrade()
	{
		EmployeeDao edao = new EmployeeDao(); 
		System.out.println("Enter Grade");
		String id = sc.next();
		edao.searchGrade(id);
	}

	public void searchMaritalStatus()
	{
		EmployeeDao edao = new EmployeeDao(); 
		System.out.println("Enter Marital Status");
		String id = sc.next();
		edao.searchMS(id);
	}
}

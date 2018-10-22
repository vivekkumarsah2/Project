package com.cg.employee.service;

import java.util.Scanner;
import com.cg.employee.dao.EmployeeDao;

public class EmployeeService
{
	Scanner sc = new Scanner(System.in);
	EmployeeDao edao = new EmployeeDao();

	public void searchID()
	{
		System.out.println("Enter Search ID");
		String id = sc.next();
		id.replace('?', '_');
		id.replace('*', '%');
		edao.search("emp_id", id);
	}

	public void searchFName()
	{
		System.out.println("Enter First Name");
		String id = sc.next();
		id.replace('?', '_');
		id.replace('*', '%');
		edao.search("Emp_first_name", id);
	}

	public void searchLName()
	{
		System.out.println("Enter Last Name");
		String id = sc.next();
		id.replace('?', '_');
		id.replace('*', '%');
		edao.search("Emp_last_name", id);
	}

	public void searchDepartment()
	{
		System.out.println("Enter Department id");
		String id = sc.next();
		edao.search("Emp_id", id);
	}

	public void searchGrade()
	{
		System.out.println("Enter Grade");
		String id = sc.next();
		edao.search("Emp_grade", id);
	}

	public void searchMaritalStatus()
	{
		System.out.println("Enter Marital Status");
		String id = sc.next();
		edao.search("Emp_Marital_Status", id);
	}
}

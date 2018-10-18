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
		edao.s_ID(id);
	}

	public void searchFName()
	{
		
	}

	public void searchLName()
	{
		
	}

	public void searchDepartment()
	{
		
	}

	public void searchGrade()
	{
		
	}

	public void searchMaritalStatus()
	{
		
	}

}

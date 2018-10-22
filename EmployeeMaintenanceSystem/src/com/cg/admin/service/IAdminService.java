package com.cg.admin.service;

import com.cg.employee.bean.Employee;

public interface IAdminService
{	
	public boolean validate(Employee ob);
	
	public void add() ;
	
	public void modify();
	
	public void display();
}

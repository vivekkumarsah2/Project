package com.cg.admin.dao;

import com.cg.employee.bean.Employee;

public interface IAdminDao
{
	public void AdmCon();
	
	public void add(Employee e) ;
	
	public void modify(String id,String field, String mod);
	
	public void modifyInt(String id, String field, int mod);
	
	public void display();
}

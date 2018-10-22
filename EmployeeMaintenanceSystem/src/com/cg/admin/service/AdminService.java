package com.cg.admin.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.cg.admin.dao.AdminDao;
import com.cg.employee.bean.Employee;

@SuppressWarnings("serial")
class InvalidInputException extends Exception
{
	InvalidInputException(String s)
	{
		super(s);
	}	
}

public class AdminService
{
	Scanner sc = new Scanner(System.in);
	
	public Date Accept_date() throws ParseException
	{
		String dt;
		dt = sc.next();
		Date dte =  (Date) new SimpleDateFormat("dd/mm/yyyy").parse(dt);
		return dte;
	}
	public boolean validate(Employee ob)
	{
		boolean f=true;
		try
		{
			if(Integer.parseInt(ob.getEId()) <100000 || Integer.parseInt(ob.getEId())>999999)
			{
				f = false;
				throw new InvalidInputException("Invalid employee id entered! Please enter a 6 digit employee id (e.g: 596325).");
			}
			if( (ob.getEFName().equals(null)) || (ob.getELName().equals(null)) )
			{
				f = false;
				throw new InvalidInputException("Invalid name entered! Enter a valid name (e.g: Smith Jones)");
			}
			if(!(ob.getEFName().matches("[A-Za-z]") && ob.getELName().matches("[A-Za-z]")))
			{
				f = false;
				throw new InvalidInputException("Invalid name entered! Enter a valid name (e.g: Smith Jones)");
			}
			if(ob.getEDesignation().length()>50)
			{
				f = false;
				throw new InvalidInputException("No. of characters in designation can't exceed 50 characters.");
			}
			if(ob.getEGrade()!="M1" && ob.getEGrade()!="M2" && ob.getEGrade()!="M3" && ob.getEGrade()!="M4" && ob.getEGrade()!="M5" && ob.getEGrade()!="M6" && ob.getEGrade()!="M7" )
			{
				f = false;
				throw new InvalidInputException("Invalid value of grade entered!");
			}
			if(!(ob.getEGender().equalsIgnoreCase("male") || ob.getEGender().equalsIgnoreCase("female")))
			{
				f = false;
				throw new InvalidInputException("Gender can be only male or female.");
			}
			if(!(ob.getEMaritalStatus().equalsIgnoreCase("Single")) || (ob.getEMaritalStatus().equalsIgnoreCase("married")) || (ob.getEMaritalStatus().equalsIgnoreCase("divorced")) || (ob.getEMaritalStatus().equalsIgnoreCase("separated")) || (ob.getEMaritalStatus().equalsIgnoreCase("widowed")))
			{
				f = false;
				throw new InvalidInputException("Invalid value of marital status entered!");
			}
//			if(ob.getDOB().getYear()>ob.getDOJ().getYear() )
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of date of joining entered!");
//			}
			
		}
		catch(InvalidInputException e)
		{
			System.err.println(e.getMessage());
			f = false;
		}
		return f;
	}
	
	public void add() 
	{
		Employee e = new Employee();
		AdminDao adao = new AdminDao();
		
		boolean f=false;
		while(f==false)
		{
			System.out.println("Enter your ID");
			e.setEId(sc.next());
			System.out.println("Enter your first name");
			e.setEFName(sc.next());
			System.out.println("Enter your last name");
			e.setELName(sc.next());
		
			try
			{
				System.out.println("Enter your Date of birth (in dd/mm/yyyy) format");
				Date dob = Accept_date();
				e.setDOB(dob);
				System.out.println("Enter date of joining (in dd/mm/yyyy) format");
				Date doj = Accept_date();
				e.setDOJ(doj);
			}
			catch(ParseException p)
			{
				p.printStackTrace();
			}
		
			System.out.println("Enter department id");
			e.setDeptId(sc.nextInt());
			System.out.println("Enter employee grade (M1, M2, M3, M4, M5, M6, M7)");
			e.setEGrade(sc.next());
			System.out.println("Enter designation");
			e.setEDesignation(sc.next());
			System.out.println("Enter basic salary");
			e.setEBasic(sc.nextInt());
			System.out.println("Enter gender");
			e.setEGender(sc.next());
			System.out.println("Enter marital status (1. Single 2. Married 3. Divorced 4. Separated 5. Widowed)");
			e.setEMaritalStatus(sc.next());
			System.out.println("Enter address");
			e.setEAddress(sc.next());
			System.out.println("Enter contact number");
			e.setEContact(sc.next());
			validate(e);
		}
		adao.add(e);
		
	}

	public void modify()
	{
		AdminDao adao = new AdminDao();
	
		int ch;
		String str=null;
		String id;
		String mod=null;
		System.out.println("Enter the employee id you want to modify:");
		id = sc.next();
		boolean f = true;
		while(f)
		{
			System.out.println("Enter the field you want to modify:\n1. First Name\n2. Last Name\n3. Department ID\n4. Grade\n5. Designation\n6. Basic salary\n7. Marital status\n8. Home address\n9. Contact number");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1 :System.out.println("Enter your first name");
						mod = sc.next();
						str = "Emp_First_Name";
						break;
				case 2 :System.out.println("Enter your last name");
						mod = sc.next();
						str = "Emp_Last_Name";
						break;
				case 3 :System.out.println("Enter department id");
						mod = sc.next();
						str = "Emp_Dept_ID";
						break;
				case 4 :System.out.println("Enter employee grade (M1, M2, M3, M4, M5, M6, M7)");
						mod = sc.next();
						str = "Emp_Grade"; 
						break;
				case 5 :System.out.println("Enter designation");
						mod = sc.next();
						str = "Emp_Designation"; 
						break;
				case 6 :System.out.println("Enter basic salary");
						mod = sc.next();
						str = "Emp_Basic"; 
						break;
				case 7 :System.out.println("Enter marital status (1. Single 2. Married 3. Divorced 4. Separated 5. Widowed)");
						mod = sc.next();
						str = "Emp_Marital_Status"; 
						break;
				case 8 :System.out.println("Enter address");
						mod = sc.next();
						str = "Emp_Home_Address"; 
						break;
				case 9 :System.out.println("Enter contact number");
						mod = sc.next();
						str = "Emp_Contact_Num"; 
						break;
				default: System.out.println("Please enter correct option.");
			}
			if(!(str.equals(null)))
			{
				if(str.equalsIgnoreCase("Emp_Basic") || str.equalsIgnoreCase("Emp_Dept_ID"))
				{
					int a = Integer.parseInt(mod);
					adao.modifyInt(id, str, a);
				}
				else
					adao.modify(id, str, mod);
			}
			System.out.println("Do you want to modify another field? (true/false)");
			f = sc.nextBoolean();
		}
	}

	public void display()
	{
		
		
	}
}

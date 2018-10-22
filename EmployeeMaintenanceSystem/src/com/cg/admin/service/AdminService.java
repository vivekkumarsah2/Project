package com.cg.admin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
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
	
	/*private static java.sql.Date convertUtilToSql(java.util.Date d){
		
		java.sql.Date sd = new java.sql.Date();
		return sd;
		
	}*/
	
	public Date Accept_date()
	{
//		String dt;
//		dt = sc.next();
//		java.util.Date dte =  (Date) new SimpleDateFormat("dd/mm/yyyy").parse(dt);
//		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter a date like (13/10/2018)");
	
		
		String s = sc.next();
		String d[] = s.split("/");
		
		int day= Integer.parseInt(d[0]);
		int month= Integer.parseInt(d[1]);
		int year= Integer.parseInt(d[2]);
		
		LocalDate l = LocalDate.of(year, month, day);
		Date date = Date.valueOf(l);
		
		return date;
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
			if( (ob.getEFName().equals(null)) && (ob.getELName().equals(null)) )
			{
				f = false;
				throw new InvalidInputException("Invalid name entered! Name can't be null. Enter a valid name (e.g: Smith Jones)");
			}
			if(!(ob.getEFName().matches("[A-Za-z]+") && ob.getELName().matches("[A-Za-z]+")))
			{
				f = false;
				throw new InvalidInputException("Invalid name entered! Can contain only characters. Enter a valid name (e.g: Smith Jones)");
			}
			if(ob.getEDesignation().length()>50)
			{
				f = false;
				throw new InvalidInputException("No. of characters in designation can't exceed 50 characters.");
			}
			if(!(ob.getEGrade().equalsIgnoreCase("M1") || ob.getEGrade().equalsIgnoreCase("M2") || ob.getEGrade().equalsIgnoreCase("M3") || ob.getEGrade().equalsIgnoreCase("M4") || ob.getEGrade().equalsIgnoreCase("M5") || ob.getEGrade().equalsIgnoreCase("M6") || ob.getEGrade().equalsIgnoreCase("M7")))
			{
				f = false;
				throw new InvalidInputException("Invalid value of grade entered!");
			}
			if(!(ob.getEGender().equalsIgnoreCase("male") || ob.getEGender().equalsIgnoreCase("female")))
			{
				f = false;
				throw new InvalidInputException("Gender can be only male or female.");
			}
//			if(!(ob.getEMaritalStatus().equalsIgnoreCase("Single")))
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of marital status entered!");
//			}
//			if(!(ob.getEMaritalStatus().equalsIgnoreCase("Married")))
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of marital status entered!");
//			}
//			if(!(ob.getEMaritalStatus().equalsIgnoreCase("Divorced")))
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of marital status entered!");
//			}
//			if(!(ob.getEMaritalStatus().equalsIgnoreCase("Separated")))
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of marital status entered!");
//			}
//			if(!(ob.getEMaritalStatus().equalsIgnoreCase("Widowed")))
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of marital status entered!");
//			}
//			if(ob.getDOB().getYear()>ob.getDOJ().getYear() )
//			{
//				f = false;
//				throw new InvalidInputException("Invalid value of date of joining entered!");
//			}
			
		}
		catch(InvalidInputException e)
		{
			System.out.println("\n\nMaybe incorrect values.\n");
			System.err.println(e.getMessage());
			f = false;
		}
		return f;
	}
	
	public void add() 
	{
		Employee e = new Employee();
		AdminDao adao = new AdminDao();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
			}
			catch(Exception p)
			{
				System.out.println("DOB method not performed.");
				p.printStackTrace();
			}
			try
			{
				System.out.println("Enter date of joining (in dd/mm/yyyy) format");
				Date doj = Accept_date();
				e.setDOJ(doj);
			}
			catch(Exception p)
			{
				System.out.println("DOJ method not performed.");
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
			try {
				e.setEAddress(br.readLine());
			} 
			catch (IOException e1) 
			{
				System.out.println("Buffered reader not active.");
				e1.printStackTrace();
			}
			System.out.println("Enter contact number");
			e.setEContact(sc.next());
			f = validate(e);
		}
		adao.add(e);
		
	}

	public void modify()
	{
		AdminDao adao = new AdminDao();
	
		int ch , modint;
		String id;
		String mod=null;
		System.out.println("\nEnter the employee id you want to modify:");
		id = sc.next();
		boolean f = true;
		while(f)
		{
			System.out.println("\nEnter the field you want to modify:\n1. First Name\n2. Last Name\n3. Department ID\n4. Grade\n5. Designation\n6. Basic salary\n7. Marital status\n8. Home address\n9. Contact number");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1 :System.out.println("Enter your first name");
						mod = sc.next();
						adao.modifyFname(mod , id);
						System.out.println("\nFirst name modified.");
						break;
				case 2 :System.out.println("Enter your last name");
						mod = sc.next();
						adao.modifyLname(mod , id);
						System.out.println("\nLast name modified.");
						break;
				case 3 :System.out.println("Enter department id");
						modint = sc.nextInt();
						adao.modifyDept(modint , id);
						System.out.println("\nDepartment id modified.");
						break;
				case 4 :System.out.println("Enter employee grade (M1/M2/M3/M4/M5/M6/M7)");
						mod = sc.next();
						adao.modifyGrade(mod , id);
						System.out.println("\nEmployee grade modified.");
						break;
				case 5 :System.out.println("Enter designation");
						mod = sc.next();
						adao.modifyDsgn(mod , id);
						System.out.println("\nDesignation modified.");
						break;
				case 6 :System.out.println("Enter basic salary");
						modint = sc.nextInt();
						adao.modifyBasic(modint , id);
						System.out.println("\nBasic salary modified.");
						break;
				case 7 :System.out.println("Enter marital status (Single/Married/Divorced/Separated/Widowed)");
						mod = sc.next();
						adao.modifyMS(mod , id);
						System.out.println("\nMarital status modified.");
						break;
				case 8 :System.out.println("Enter address");
						mod = sc.next();
						adao.modifyAddress(mod , id);
						System.out.println("\nAddress modified.");
						break;
				case 9 :System.out.println("Enter contact number");
						mod = sc.next();
						adao.modifyContact(mod , id);
						System.out.println("\nContact number modified.");
						break;
				default: System.out.println("\nPlease enter correct option. (1-9)");
			}
			
			System.out.println("\n\nDo you want to modify another field? (true/false)");
			f = sc.nextBoolean();
		}
	}

	public void display()
	{
		AdminDao adao = new AdminDao();
		adao.display();
	}
}

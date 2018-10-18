package com.cg;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.cg.service.AuthenticationService;

public class Login
{
	static Logger Log=Logger.getLogger(Login.class.getName());
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		boolean f1=false;
		AuthenticationService as = new AuthenticationService();
		
		while(f1==false)
		{
			System.out.println("Enter id: ");
			String uid = sc.next();
			System.out.println("Enter user name :");
			String uname = sc.next();
			System.out.println("Enter password :");
			String upassword = sc.next();	
				
			f1 = as.Authenticate(uid, uname, upassword);
		}
		
		
		
		
//		System.out.println("Select your choice :\n1. Admin\n2. Employee");
//		Integer c = sc.nextInt();
//		boolean f = true;
//		while(f)
//		switch(c)
//		{
//			case 1: AdminLogin al = new AdminLogin();
//					f = false;
//					break; 
//			case 2: EmployeeLogin el = new EmployeeLogin();
//					f = false;
//					break;
//			default: System.out.println("Enter correct choice.");
//		}
		sc.close();
	}
}

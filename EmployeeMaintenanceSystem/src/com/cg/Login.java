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
			System.out.println("Enter user id: ");
			String uid = sc.next();
			System.out.println("Enter user name :");
			String uname = sc.next();
			System.out.println("Enter password :");
			String upassword = sc.next();	
				
			f1 = as.Authenticate(uid, uname, upassword);
		}
		System.out.println("\nYou have successfully logged off from the system!");
		sc.close();
	}
}

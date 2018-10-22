package com.cg.admin.ui;

import java.util.Scanner;
import com.cg.admin.service.AdminService;

public class AdminUI
{
	public void admin()
	{
		AdminService as = new AdminService();
		Scanner sc = new Scanner(System.in);
		
		boolean flag=true;
		while(flag)
		{
			System.out.println("\nSelect an option to perform: ");
			System.out.println("1. Add employee details\n2. Modify employee details\n3. Display employee details");
			Integer ch = sc.nextInt();
		
			switch(ch)
			{
			case 1:	as.add(); 
					System.out.println("\nEmployee details added.");
					break;
			case 2: as.modify(); 
					System.out.println("\nEmployee details modified.");
					break;
			case 3: as.display(); 
					System.out.println("\nEmployee details displayed.");
					break;
			default: System.out.println("\nYou have entered a wrong choice! Please enter correct option (1-3)");
			}
			System.out.println("\n\nDo you want to perform another operation on employee details? (true/false)");
			flag = sc.nextBoolean();
		}
		sc.close();		
	}
}

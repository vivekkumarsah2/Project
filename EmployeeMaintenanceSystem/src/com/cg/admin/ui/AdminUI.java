package com.cg.admin.ui;

import java.util.Scanner;
import com.cg.admin.service.AdminService;

public class AdminUI
{
	public void admin()
	{
		AdminService as = new AdminService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Select an option to perform: ");
		System.out.println("1. Add employee details\n2. Modify employee details\n3. Display employee details");
		Integer ch = sc.nextInt();
		
		switch(ch)
		{
			case 1:	as.add();
					break;
			case 2: as.modify();
					break;
			case 3: as.display();
					break;
			default: System.out.println("You have entered a wrong choice! Please enter correct option (1-3)");
		}
		sc.close();		
	}
}

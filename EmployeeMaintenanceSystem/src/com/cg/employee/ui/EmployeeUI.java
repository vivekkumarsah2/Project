package com.cg.employee.ui;

import java.util.Scanner;
import com.cg.employee.service.EmployeeService;

public class EmployeeUI
{
	public void employee()
	{	
		Scanner sc = new Scanner(System.in);
		EmployeeService es = new EmployeeService();
		
		boolean flag = true;
		while(flag== true)
		{
			System.out.println("Select to search an employee: ");
			System.out.println("1. ID \n2. First Name \n3. Last Name \n4. Department \n5. Grade \n6. Marital Status");
			Integer ch = sc.nextInt();	
			switch(ch)
			{
			case 1:	es.searchID();
					break;
			case 2: es.searchFName();
					break;
			case 3: es.searchLName();
					break;
			case 4: es.searchDepartment();
					break;
			case 5: es.searchGrade();
					break;
			case 6: es.searchMaritalStatus();
					break;
			default: System.out.println("You have entered a wrong choice! Please enter correct option (1-6)");
			}
			System.out.println("Do you want to search an employee again? (true/false)");
			flag = sc.nextBoolean();
		}
		sc.close();
	}
}

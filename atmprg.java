package assignment3;

import java.util.Scanner;

class MyException extends Exception{
	private int detail;
	MyException(int a){
		detail=a;
		
	}
	public String toString()
	{
		return "MyException:Invalid option";
	}
}
class withexp extends Exception{
	private double amount;
	withexp(double a){
		amount=a;
		
	}
	public String toString()
	{
		return "withexp: insufficient balance.Enter another amount";
	}
	}
public class atmprg  {
	public static Scanner kbd= new Scanner(System.in);
	public static void displayBalance(double x)
	 {
		 System.out.print("\n Your Current Balance is Rs.%.2f\n"+ x);
	 }
	 public static double deposit(double x,double y)
	 {
		double depositatm=y;
		double currentbal=x;
		double newbal=depositatm + currentbal;
		System.out.println("Your new balance id .2f\n"+ newbal);
		return newbal;
		 }
	 public static double withdraw(double x,double y)
	 {
			double withdrawatm=y;
			double currentbal=x;
			double newbal=currentbal-withdrawatm;
			System.out.println("Your new balance id .2f\n"+newbal);
			
			return newbal; 
	 }
	
	public static int menu()
	{
       
		int menuChoice;
		do{
			System.out.println("Please choose from following options:"+"\n 1)Display Balance"+"\n2)Deposit"
		+"\n 3)Withdraw money"+"\n 4)LogOUt\n\n");
			try{
			menuChoice=kbd.nextInt();
			if(menuChoice<1 || menuChoice>4)
			{
				throw new MyException(menuChoice);
			}
			
			}catch(MyException e){
			System.out.println("Caught"+e);
		}
			menuChoice=kbd.nextInt();
		}while(menuChoice<1 || menuChoice>4);
		return menuChoice;
	}
	public static void main(String args[]){
		String accnm, pass;
		int minbal=10000;
		
		int menuOption=0;
		double depositatm,withdrawatm,currentbal=0;
		 System.out.println("Enter your Account Number:");
		 accnm=kbd.next();
		 System.out.println("Enter your password:");
		 pass=kbd.next();
		 currentbal=minbal;
		 while(menuOption!=4){
			 menuOption= menu();
			 switch(menuOption){
			 case 1:
				 displayBalance(currentbal);
				 break;
			  case 2:
				 System.out.println("enter the amount to be deposited:");
			 depositatm=kbd.nextDouble();
			 currentbal=deposit(currentbal,depositatm);
			 break;
			  case 3:
					 System.out.println("enter the amount to withdraw:");
					 try{
					 withdrawatm=kbd.nextDouble();
					 if(withdrawatm>currentbal)
						 throw new withexp(withdrawatm);
					 }catch(withexp e){
						 System.out.println("Caught"+ e);
					 }
					 withdrawatm=kbd.nextDouble();
					 currentbal= withdraw(currentbal,withdrawatm);
					 break;
			  case 4:
				  System.out.println("Successful log out.Have a nice day.Bye!!");
				  System.exit(0);
				  break;
	  
			 
			 
		 }
			 
		
	}
}
	}




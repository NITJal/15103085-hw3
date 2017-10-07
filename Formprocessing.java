package assignment3;

import java.io.IOException;
import java.util.Scanner;
 
class InValidMarksException extends Exception
{
	InValidMarksException(String message)
	{
		super(message);
	}
}

public class Formprocessing {
	public static void details( )
	{
		
		int x=0;
		int z;
	String [] name = new String[30];
	String[] email=new String[30];
	 int []rollno = new int[30];
	int [] marksUG = new int[30];
	int[] marksHSC= new int[30];
	String[] address= new String[30];
	int[] phonenm = new int[30];
	Scanner input= new Scanner(System.in);
	String [] statusHSC = new String[30];
	String[] statusUG= new String[30];
	
	try{
		for( z=x;z<=29;z++,x++)
		{

			System.out.println("Full name:");
			name[z]=input.nextLine();		
			System.out.println("Roll number:");
			rollno[z]=input.nextInt();		
			System.out.println("email:");
			email[z]=input.nextLine();		
			System.out.println("Address:");
			address[z]=input.nextLine();		
			System.out.println("Phone number:");
			phonenm[z]=input.nextInt();	
			try{
			System.out.println("Marks UG:");
			marksUG[z]=input.nextInt();
			System.out.println("Marks HSC:");
			marksHSC[z]=input.nextInt();
			if( marksUG[z]<0 || marksUG[z]>100||marksHSC[z]<0||marksHSC[z]>100)
				throw new InValidMarksException("Invalid Marks Input Error");
			}catch(InValidMarksException e){
				System.out.println(e.getMessage());
			}
			
			
		}
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Array index out-of-bounds"+e);
	}
	for(z=0;z<=29;z++)
	{
		if(marksHSC[z]>= 60)
			statusHSC[z]="Eligible";
		else
			statusHSC[z]="Not Eligible";
		if(marksUG[z]>=70)
			statusUG[z]="Eligible";
		else
			statusUG[z]="Not Eligible";
			
	}
	
	}
	public static void main(String args[]){
		int choice;
		System.out.println("Enter your choice: \n 1) Details\n ) 2)Logout");
		Scanner sc= new Scanner(System.in);
		choice = sc.nextInt();
		while(choice!= 2)
		{
			switch(choice)
			{
			case 1:
				details();
			case 2:
				System.out.println("logged of.have a nice day");
			}
				
		}
	}

}

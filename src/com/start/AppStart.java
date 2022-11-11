package com.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

import com.start.user.LoggedInUserFunc;
import com.start.user.User;
import com.start.user.UserMeth;

public class AppStart {
public static void main(String[] args) throws IOException {
	System.out.println("Hello! Welcome to Twitter");
	//System.out.println("");
	//Scanner sc = new Scanner(System.in);
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	while(true)
	{
		System.out.println("New User? Press 1 to Register ");
		System.out.println("Existing User? Press 2 to Login");
		System.out.println("Forgot Password? Press 3 to reset password ");
		
		//int choice =Integer.parseInt(br.readLine());
		
		int choice = Integer.parseInt(sc.readLine());
		
		//Register a new user
		if(choice==1)
		{
			
			System.out.println("-----------Registration form-----------");
			System.out.println("Enter your first name");
			String name = sc.readLine();
			
			System.out.println("Enter your Email");
			String email = sc.readLine();
			
			System.out.println("Set up your password");
			String password = sc.readLine();
			
			//obj creation in User class
			User st = new User(name,email,password);
			System.out.println(st);
			
			//adding user details to DB with the help of created obj
			boolean status = UserMeth.registerUser(st);
			if(status)
				System.out.println("User added successfully");
			else
				System.out.println("Error ocurred!!please check it");
		}
		//Login
		else if(choice==2)
		{
			//login and options should change
			System.out.println("Enter your registered Email");
			String email =sc.readLine();
			
			System.out.println("Enter password");
			String pass = sc.readLine();
			
			//passing these values login method
			boolean status = UserMeth.login(email, pass);
			if(status)
			{
				System.out.println("Login Successful");
				//user status is Active
				//menu options for logged in user
				LoggedInUserFunc.userFunc(status,email);
				
			}
			else
				System.out.println("Given user creds doesn't match");
			
		}
		//reset password
		else if(choice==3)
		{
			 System.out.println("Enter registered email address");
			 String email = sc.readLine();
			 System.out.println("Enter your new password");
			 String pass = sc.readLine();
			 
			boolean status = UserMeth.resetPassword(email, pass);
			if(status)
				System.out.println("Password reset successful");
			else
				System.out.println("Unable to reset password. Please try again");
		}
		else if(choice>3){
			System.out.println("Enter a valid number");
		}
	}
	
	
}
}

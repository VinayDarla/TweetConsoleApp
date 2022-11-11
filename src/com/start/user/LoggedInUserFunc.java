package com.start.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class LoggedInUserFunc {

	public static void userFunc(boolean status,String email) throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		while(status)
		{
			System.out.println("<-------------Logged In User's Menu------->");
			System.out.println("Press 1 to post a tweet");
			System.out.println("Press 2 to get tweets posted by user");
			System.out.println("Press 3 to get all registered users and their tweets");
			System.out.println("Press 4 to Update password");
			System.out.println("Press 5 to Logout");
			
			int choice = Integer.parseInt(sc.readLine());
			//posting a tweet
			if(choice==1)
			{
				System.out.println("Enter your message");
				String tweet =sc.readLine();
				
				//passing these values
				boolean tweetStatus = UserMeth.postTweet(email,tweet);
				if(tweetStatus)
					System.out.println("Tweet successfully posted");
				else
					System.out.println("Error has ocurred. Please check");
				
			}
			//get tweets posted by current user
			else if(choice == 2) 
				UserMeth.getUserTweets(email);
			
			//display all registered users and their tweets
			else if(choice == 3)
				UserMeth.getAllTweets();
			
			//update password
			else if(choice == 4)
			{
				System.out.println("Enter your old password");
				String password = sc.readLine();
				System.out.println("Enter new password");
				String newPassword = sc.readLine();
				
				//passing these values
				boolean updateStatus=UserMeth.updatePassword(email,password,newPassword);
				if(updateStatus)
					System.out.println("Password updated successfully");
				else
					System.out.println("Unable to update password. Please Enter valid details");
			}
			//logout
			else if(choice==5) {
				status = !status;
				System.out.println("User successfully logged off");
			}
			
		}
	}
}

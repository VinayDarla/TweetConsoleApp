package com.junit.userTestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.start.user.LoggedInUserFunc;
import com.start.user.User;
import com.start.user.UserMeth;




public class UserTest {

	@Test
	@DisplayName("Register new user")
	public void testRegisterMethod() {
		User st = new User("Aman","aman@gmail.com","aman");
		boolean status = UserMeth.registerUser(st);
		if(status)
			System.out.println("User added");
		else 
			System.out.println("Unable to add User. Check again.");
		
	}
	@Test
	@DisplayName("User login")
	public void testLogin() {
		boolean status = UserMeth.login("aman@gmail.com", "aman");
		if(status)
			System.out.println("Login Successful");
		else
			System.out.println("Can't login. Please check your creds");
		
	}
	@Test
	@DisplayName("Posting tweet")
	public void testPostTweet() {
		boolean status = UserMeth.postTweet("aman@gmail.com","Hello everyone! I am Aman your new colleague");
		if(status)
			System.out.println("Tweet posted Successfully");
		else
			System.out.println("Unable to post tweet");
		
	}
}

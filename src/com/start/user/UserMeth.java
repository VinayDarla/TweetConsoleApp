package com.start.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.start.user.SqlConnection;

public class UserMeth {

	//register a new user
	public static boolean registerUser(User st) 
	{
		boolean status = false;
		
		try {
			Connection con = SqlConnection.createConnection();
			String query1 = "insert into user_data(name,email,password)"+" values (?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query1);
			
			//setting values
			stmt.setString(1, st.getUserName());
			stmt.setString(2, st.getEmail());
			stmt.setString(3, st.getPassword());
			
			//executing query
			stmt.executeUpdate();
			status =true;
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	return status;	
	}
	//login
	public static boolean login(String mail, String password)
	{
		boolean status = false;
		try {
			Connection con = SqlConnection.createConnection();
			//to check user name and password
			String query = "select password from user_data where email=?";
			//Statement stmt = con.createStatement();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, mail);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next())
			{
				//compare creds with DB
				
				//if(creds.getEmail()) if u want to check by passing User class obj as reference
				if(password.equals(set.getString(1)) )
				{
					//System.out.println("Login successful");
					status = true;
				}
			}
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	return status;
	}
	//reset password
	public static boolean resetPassword(String mail,String newPassword) {
		boolean status = false;
		
		try {
			Connection con = SqlConnection.createConnection();
			String query = "update user_data set password=? where email=?";
			PreparedStatement stmt = con.prepareStatement(query);
			//setting values
			stmt.setString(1, newPassword);
			stmt.setString(2, mail);
			
			//execute statement
			stmt.executeUpdate();
			status =true;
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	return status;
	}
	
	
	//post a tweet
	public static boolean postTweet(String email,String tweet)
	{
		boolean status = false;
		
		try {
			Connection con = SqlConnection.createConnection();
			String query = "insert into tweets(email,messages) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			//user status is checked in "userFunc"
			//posting tweet to db
			stmt.setString(1, email);
			stmt.setString(2, tweet);
			
			stmt.executeUpdate();
			status =true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	return status;
	}
	
	
	//get user tweets
	public static void getUserTweets(String email) {
		
		try {
			Connection con =SqlConnection.createConnection();
			String query = "select user_data.userID,user_data.name, tweets.messages from user_data,tweets where "
					+ "user_data.email=? and tweets.email=?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			//giving values in place of ?
			stmt.setString(1, email);
			stmt.setString(2, email);
			
			//execute query
			ResultSet set = stmt.executeQuery();
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String tweets = set.getString(3);
				System.out.println("User-ID: " +id+"   Username: "+name+"   Email: "+email+"    Tweets: "+tweets);
			}
		} 
		catch (Exception e) {
			
		}
		
	}

	
	//get all tweets in db
	public static void getAllTweets() {
		
		try {
			Connection con = SqlConnection.createConnection();
			String query1 = "select user_data.userID,user_data.name,tweets.email, tweets.messages from user_data,tweets where "
					+ "user_data.email=tweets.email";
			
			Statement stmt = con.createStatement();
			//executing query
			ResultSet set = stmt.executeQuery(query1);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String email = set.getString(3);
				String tweets = set.getString(4);
				System.out.println("User-ID: " +id+"   Username: "+name+"   Email: "+email+"    Tweets: "+tweets);
				
			}
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//update password
	public static boolean updatePassword(String mail,String oldPassword,String newPassword) {
		boolean status = false;
		
		try {
			Connection con = SqlConnection.createConnection();
			String query = "update user_data set password=? where email=? and password=?";
			PreparedStatement stmt = con.prepareStatement(query);
			//setting values
			stmt.setString(1, newPassword);
			stmt.setString(2, mail);
			stmt.setString(3, oldPassword);
			
			//execute statement
			stmt.executeUpdate();
			status =true;
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	return status;
	}
	
}

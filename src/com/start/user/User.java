package com.start.user;

public class User {
private int userID;
private String userName, email,password;

//constructors
public User(int userID, String userName, String email, String password) {
	super();
	this.userID = userID;
	this.userName = userName;
	this.email = email;
	this.password = password;
	
}

public User(String userName, String email, String password) {
	super();
	this.userName = userName;
	this.email = email;
	this.password = password;
	
}

public User() {
	super();
	
}

//getters and setters
public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



@Override
public String toString() {
	return "User [userid=" + userID + ", userName=" + userName + ", email=" + email 
			+ "]";
}



}

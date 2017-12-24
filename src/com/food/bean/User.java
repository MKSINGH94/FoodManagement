package com.food.bean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class User {

 private String email_name;
@NotNull
 private String password;



public void setEmail_name(String email_name) {
	this.email_name = email_name;
}
public void setPassword( String  password) {
	this.password = password;
}

@NotNull 
public String getEmail_name() {
	return email_name;
}
@NotNull 
public String getPassword() {
	return password;
}




}

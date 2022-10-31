package com.domain;



public class Login {

private String emailid;
private String password;

private String typeOfUser;

public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTypeOfUser() {
	return typeOfUser;
}
public void setTypeOfUser(String typeOfUser) {
	this.typeOfUser = typeOfUser;
}
@Override
public String toString() {
	return "Login [emailid=" + emailid + ", password=" + password + ", typeOfUser=" + typeOfUser + "]";
}

}
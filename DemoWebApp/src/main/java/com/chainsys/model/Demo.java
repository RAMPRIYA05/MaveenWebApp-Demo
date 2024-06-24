package com.chainsys.model;

public class Demo {
       String name;
       String emailId;
       String Password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Demo [name=" + name + ", emailId=" + emailId + ", Password=" + Password + "]";
	}
       
       
}

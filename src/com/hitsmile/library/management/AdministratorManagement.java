package com.hitsmile.library.management;


public class AdministratorManagement {
	
	private static final String mUserName = "myAdmin";
	private static final String mPassword = "admin";
	

	public static boolean isUser(String userName,String password){
		if(userName.equals(mUserName)&&password.equals(mPassword)){
			return true;
		}else{
			return false;
		}
	}
}

package com.davlanca.billmanager.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.davlanca.billmanager.service.UserService;

public class LoginController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String password;
	private String userName;
	
	private UserService userService;
		
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @param username the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String checkLogin() {
		
		return "success";
	}
	
}
package com.davlanca.billmanager.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;

import com.davlanca.billmanager.service.UserService;
import com.davlanca.billmanager.util.Global;
import com.davlanca.billmanager.util.MobileViewHandler;

public class LoginController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private static final Logger log = Logger.getLogger(LoginController.class.getName());
	
	private boolean mobileDevice;
	
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
		String action = "success";
        String renderKitId = FacesContext.getCurrentInstance().getViewRoot().getRenderKitId();   
        
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        setMobileDevice(request.getSession().getAttribute("isMobileDevice").equals(Global.TRUE));

        //log.info("session.isMobileDevice: " + request.getSession().getAttribute("isMobileDevice").equals(Global.TRUE));
        log.info("session.isMobileDevice: " + isMobileDevice());
        log.info("renderKitId: " + renderKitId);
        
        
        
        if(renderKitId.equalsIgnoreCase("PRIMEFACES_MOBILE")){
            action = "mobile";
        }
        
        log.info("action: " + action);
        
		return action;
	}


	/**
	 * @return the mobileDevice
	 */
	public boolean isMobileDevice() {
		return mobileDevice;
	}

	/**
	 * @return the mobileDevice
	 */
	public boolean getMobileDevice() {
		return mobileDevice;
	}
	
	/**
	 * @param mobileDevice the mobileDevice to set
	 */
	public void setMobileDevice(boolean mobileDevice) {
		this.mobileDevice = mobileDevice;
	}

	
	
}
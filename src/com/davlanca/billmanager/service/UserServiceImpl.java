package com.davlanca.billmanager.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.AbstractController;

import com.davlanca.billmanager.dao.UserDAO;
import com.davlanca.billmanager.model.User;

public class UserServiceImpl implements UserService {

	private static final Logger log = Logger.getLogger(AbstractController.class.getName());
	
	@Autowired 
	private UserDAO userDAO;
	
	@Override
	public void add(User user) {
		log.info("User added successfully");
		try {
			userDAO.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

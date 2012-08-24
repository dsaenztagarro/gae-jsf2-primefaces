package com.davlanca.billmanager.dao;

import java.util.List;

import com.davlanca.billmanager.model.User;


public interface UserDAO extends GenericDAO<User> {

	public List<User> findAll();
}

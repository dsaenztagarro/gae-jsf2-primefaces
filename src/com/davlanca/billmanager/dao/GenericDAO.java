package com.davlanca.billmanager.dao;

import java.util.HashMap;
import java.util.List;

public interface GenericDAO<T> {

	public void create(T item) throws Exception;
	
	public boolean update(T item) throws Exception;
	
	public boolean remove(T item) throws Exception;

	public List<T> findBy(HashMap<String,Object> propList) throws Exception;
	
	public T getByProperty(String propName, Object propValue) throws Exception;
}

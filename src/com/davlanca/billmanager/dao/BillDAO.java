package com.davlanca.billmanager.dao;

import java.util.List;

import com.davlanca.billmanager.model.Bill;


public interface BillDAO extends GenericDAO<Bill> {

	public List<Bill> findAll();
}

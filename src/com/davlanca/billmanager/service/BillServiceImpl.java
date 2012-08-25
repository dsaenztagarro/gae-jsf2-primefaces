package com.davlanca.billmanager.service;

import java.io.Serializable;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.AbstractController;

import com.davlanca.billmanager.dao.BillDAO;
import com.davlanca.billmanager.model.Bill;

@SuppressWarnings("serial")
public class BillServiceImpl implements BillService, Serializable {

	private static final Logger log = Logger.getLogger(AbstractController.class.getName());
	
	@Autowired 
	private BillDAO billDAO;
	
	@Override
	public void add(Bill bill) {
		log.info("Bill added successfully");
		try {
			billDAO.create(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.davlanca.billmanager.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.AbstractController;

import com.davlanca.billmanager.model.Bill;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@Component
@SuppressWarnings("serial")
public class BillDAOImpl extends GenericDAOImpl implements BillDAO {

	private static final Logger log = Logger.getLogger(AbstractController.class.getName());

	public BillDAOImpl() {
	}

	@Override
	public void create(Bill bill) throws Exception {
		if (bill != null) {
			ObjectifyService.register(Bill.class);
			Objectify ofy = ObjectifyService.begin();
			
			ofy.put(bill);
		} else {
			throw new Exception("You can't create a null bill");
		}
	}

	@Override
	public boolean update(Bill bill) {

		if (bill == null)
			return false;

		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();

		boolean thisAccountAlreadyExist = ofy.query(Bill.class).get() != null;

		if (thisAccountAlreadyExist) {
			ofy.put(bill);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean remove(Bill bill) {
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();
		
		ofy.delete(bill);
		return true;
	}

	@Override
	public List<Bill> findAll() {
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();

		Query<Bill> q = ofy.query(Bill.class);
		ArrayList<Bill> bills = (ArrayList<Bill>) q.list();

		return bills;
	}
	
	@Override
    public List<Bill> findBy(HashMap<String,Object> propList) {
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();
    	
    	Query<Bill> q = ofy.query(Bill.class);
    	Iterator<String> it = propList.keySet().iterator();
    	while (it.hasNext()) {
    		String propName = it.next();
    		Object propValue = propList.get(propName);
    		
    		q.filter(propName, propValue);
    	}

    	return q.list();
    }
	
	@Override
    public Bill getByProperty(String propName, Object propValue) {
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();
    	
    	Query<Bill> q = ofy.query(Bill.class);
    	q.filter(propName, propValue);

    	Bill obj = q.get();
    	return obj;
    }
	
}
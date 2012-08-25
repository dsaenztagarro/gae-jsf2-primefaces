package com.davlanca.billmanager.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.AbstractController;

import com.davlanca.billmanager.model.Bill;
import com.davlanca.billmanager.model.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@Component
@SuppressWarnings("serial")
public class BillDAOImpl extends GenericDAOImpl implements BillDAO {

	private static final Logger log = Logger.getLogger(AbstractController.class.getName());

	//@Autowired
	//private ObjectifyFactory objectifyFactory;

	public BillDAOImpl() {
	}

	/*public BillDAOImpl(ObjectifyFactory objectifyFactory) {
		this.objectifyFactory = objectifyFactory;
	}*/

	@Override
	public void create(Bill pet) throws Exception {
		System.out.println("BillDAOImpl.bill: " + pet);
		if (pet != null) {
			//Objectify ofy = objectifyFactory.begin();
			ObjectifyService.register(Bill.class);
			Objectify ofy = ObjectifyService.begin();
			
			ofy.put(pet);
		} else {
			throw new Exception("You can't create a null pet");
		}
	}

	@Override
	public boolean update(Bill pet) {

		if (pet == null)
			return false;

		//Objectify ofy = objectifyFactory.begin();
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();

		boolean thisAccountAlreadyExist = ofy.query(Bill.class).get() != null;

		if (thisAccountAlreadyExist) {
			ofy.put(pet);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean remove(Bill pet) {
		//Objectify ofy = objectifyFactory.begin();
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();
		
		ofy.delete(pet);
		return true;
	}

	@Override
	public List<Bill> findAll() {
		//Objectify ofy = objectifyFactory.begin();
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();

		Query<Bill> q = ofy.query(Bill.class);
		ArrayList<Bill> pets = (ArrayList<Bill>) q.list();

		return pets;
	}
	
	@Override
    public List<Bill> findBy(HashMap<String,Object> propList) {
    	//Objectify ofy = objectifyFactory.begin();
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
    	//Objectify ofy = objectifyFactory.begin();
		ObjectifyService.register(Bill.class);
		Objectify ofy = ObjectifyService.begin();
    	
    	Query<Bill> q = ofy.query(Bill.class);
    	q.filter(propName, propValue);

    	Bill obj = q.get();
    	return obj;
    }
	
}
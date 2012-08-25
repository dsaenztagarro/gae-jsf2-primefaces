package com.davlanca.billmanager.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.davlanca.billmanager.model.Bill;
import com.davlanca.billmanager.service.BillService;

public class BillController implements Serializable {

	private static final long serialVersionUID = 1L;

	private BillService billService;
	private UIInput _endDateInput;
	private UIInput _startDateInput;
	
	private int amount;
	private int categoryId;
	@ManagedProperty(value = "Indicar la descripción de la factura..")
	private String description;
	private Date endDate;
	private Date paymentDate;
	private boolean periodicity;
	private Date startDate;
	private int userId;




	/**
	 * @return the billService
	 */
	public BillService getBillService() {
		return billService;
	}


	/**
	 * @return the _endDateInput
	 */
	public UIInput get_endDateInput() {
		return _endDateInput;
	}


	/**
	 * @return the _startDateInput
	 */
	public UIInput get_startDateInput() {
		return _startDateInput;
	}


	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}


	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}


	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}


	/**
	 * @return the periodicity
	 */
	public boolean isPeriodicity() {
		return periodicity;
	}


	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param billService the billService to set
	 */
	public void setBillService(BillService billService) {
		this.billService = billService;
	}


	/**
	 * @param _endDateInput the _endDateInput to set
	 */
	public void set_endDateInput(UIInput _endDateInput) {
		this._endDateInput = _endDateInput;
	}


	/**
	 * @param _startDateInput the _startDateInput to set
	 */
	public void set_startDateInput(UIInput _startDateInput) {
		this._startDateInput = _startDateInput;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}


	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	/**
	 * @param periodicity the periodicity to set
	 */
	public void setPeriodicity(boolean periodicity) {
		this.periodicity = periodicity;
		
		System.out.println("startDateInput: " + _startDateInput);
		System.out.println("periodicity: " + periodicity);
		
		_startDateInput.setRendered(periodicity);
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void validateAmount(FacesContext context, UIComponent toValidate,
			Object value) {
		int amount = ((Integer) value).intValue();
		if (!(amount > 0)) {
			FacesMessage message = new FacesMessage(
					"Amount must be greater than 0");
			FacesContext.getCurrentInstance().addMessage(null, message);
			throw new ValidatorException(message);
		}
	}

	
	public String addBill() {
		Bill bill = new Bill();
		bill.setCategoryId(getCategoryId());
		bill.setDescription(getDescription());
		bill.setPaymentDate(getPaymentDate());
		bill.setUserId(getUserId());
		
		billService.add(bill);
		
		boolean added = true;
		FacesMessage doneMessage = null;
		String outcome = null;
		if (added) {
			doneMessage = new FacesMessage("Successfully added new bill");
			outcome = "index";
		} else {
			doneMessage = new FacesMessage("Failed to add new bill");
			outcome = "index";
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}
	
}

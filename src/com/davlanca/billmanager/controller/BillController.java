package com.davlanca.billmanager.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import com.davlanca.billmanager.model.Bill;
import com.davlanca.billmanager.service.BillService;

public class BillController implements Serializable {

	private static final long serialVersionUID = 1L;

	private BillService billService;
	
	private boolean renderIntervalCalendarPanel;
	private boolean renderPunctualPanel;
	
	private UIPanel punctualPanel;
	private UIPanel intervalCalendarPanel;
	
	private String normal;
	private String mobile;
	private String tablet;
	
	private int amount;
	private int categoryId;
	@ManagedProperty(value = "Indicar la descripción de la factura..")
	private String description;
	private Date endDate;
	private Date paymentDate;
	private boolean periodicity;
	private Date startDate;
	private int userId;

	@PostConstruct
	public void init() {
		HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		setNormal((String)request.getAttribute("isNormal"));
		setMobile((String)request.getAttribute("isMobile"));
		setTablet((String)request.getAttribute("isTablet"));
	}

	/**
	 * @return the billService
	 */
	public BillService getBillService() {
		return billService;
	}

	/**
	 * @param billService the billService to set
	 */
	public void setBillService(BillService billService) {
		this.billService = billService;
	}
	
	
	/**
	 * @return the renderIntervalCalendarPanel
	 */
	public boolean isRenderIntervalCalendarPanel() {
		return renderIntervalCalendarPanel;
	}

	/**
	 * @return the renderPunctualPanel
	 */
	public boolean isRenderPunctualPanel() {
		return renderPunctualPanel;
	}

	/**
	 * @param renderIntervalCalendarPanel the renderIntervalCalendarPanel to set
	 */
	public void setRenderIntervalCalendarPanel(boolean renderIntervalCalendarPanel) {
		this.renderIntervalCalendarPanel = renderIntervalCalendarPanel;
	}

	/**
	 * @param renderPunctualPanel the renderPunctualPanel to set
	 */
	public void setRenderPunctualPanel(boolean renderPunctualPanel) {
		this.renderPunctualPanel = renderPunctualPanel;
	}
	
	/**
	 * @param periodicity the periodicity to set
	 */
	public void setPeriodicity(boolean periodicity) {
		this.periodicity = periodicity;
		System.out.println("periodicity updated");
		punctualPanel.setRendered(periodicity);
		intervalCalendarPanel.setRendered(!periodicity);
	}

	/**
	 * @return the punctualPanel
	 */
	public UIPanel getPunctualPanel() {
		return punctualPanel;
	}

	/**
	 * @return the intervalCalendarPanel
	 */
	public UIPanel getIntervalCalendarPanel() {
		return intervalCalendarPanel;
	}

	/**
	 * @param punctualPanel the punctualPanel to set
	 */
	public void setPunctualPanel(UIPanel punctualPanel) {
		this.punctualPanel = punctualPanel;
	}

	/**
	 * @param intervalCalendarPanel the intervalCalendarPanel to set
	 */
	public void setIntervalCalendarPanel(UIPanel intervalCalendarPanel) {
		this.intervalCalendarPanel = intervalCalendarPanel;
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

	/**
	 * @return the normal
	 */
	public String getNormal() {
		return normal;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @return the tablet
	 */
	public String getTablet() {
		return tablet;
	}

	/**
	 * @param normal the normal to set
	 */
	public void setNormal(String normal) {
		this.normal = normal;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @param tablet the tablet to set
	 */
	public void setTablet(String tablet) {
		this.tablet = tablet;
	}
	
	
	
}

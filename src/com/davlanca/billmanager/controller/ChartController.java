package com.davlanca.billmanager.controller;  
  
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

import com.davlanca.billmanager.service.BillService;
  
@SuppressWarnings("serial")
public class ChartController implements Serializable {  
  
	private BillService billService;
    private CartesianChartModel categoryModel;  
    private MeterGaugeChartModel meterGaugeModel;  
    private PieChartModel pieModel; 
    
    public ChartController() { 
    	createPieModel(); 
        createCategoryModel();
        createMeterGaugeModel();
    }  
  
    
    /**
	 * @return the billService
	 */
	public BillService getBillService() {
		return billService;
	}

	public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
	
    /**
	 * @return the meterGaugeModel
	 */
	public MeterGaugeChartModel getMeterGaugeModel() {
		return meterGaugeModel;
	}
	
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  	

	/**
	 * @param billService the billService to set
	 */
	public void setBillService(BillService billService) {
		this.billService = billService;
	}
	
	/**
	 * @param categoryModel the categoryModel to set
	 */
	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	/**
	 * @param meterGaugeModel the meterGaugeModel to set
	 */
	public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
		this.meterGaugeModel = meterGaugeModel;
	}


	private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("Boys");  
  
        boys.set("2004", 120);  
        boys.set("2005", 100);  
        boys.set("2006", 44);  
        boys.set("2007", 150);  
        boys.set("2008", 25);  
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Girls");  
  
        girls.set("2004", 52);  
        girls.set("2005", 60);  
        girls.set("2006", 110);  
        girls.set("2007", 135);  
        girls.set("2008", 120);  
  
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls);  
    }  
    
    private void createPieModel() {  
        pieModel = new PieChartModel();  
  
        pieModel.set("Brand 1", 540);  
        pieModel.set("Brand 2", 325);  
        pieModel.set("Brand 3", 702);  
        pieModel.set("Brand 4", 421);  
    }      
    
    private void createMeterGaugeModel() {  
    	  
        List<Number> intervals = new ArrayList<Number>(){{  
            add(20);  
            add(50);  
            add(120);  
            add(220);  
        }};  
  
        meterGaugeModel = new MeterGaugeChartModel("Umbral de Alerta",140, intervals);  
    }      
}  
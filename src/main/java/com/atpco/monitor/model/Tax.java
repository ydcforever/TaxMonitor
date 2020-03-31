package com.atpco.monitor.model;

public class Tax {

	private String sales_curr;
	private String tax_code;
	private double tax_amount;

	public String getSales_curr() {
		return sales_curr;
	}

	public void setSales_curr(String salesCurr) {
		sales_curr = salesCurr;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String taxCode) {
		tax_code = taxCode;
	}

	public double getTax_amount() {
		return tax_amount;
	}

	public void setTax_amount(double tax_amount) {
		this.tax_amount = tax_amount;
	}
}

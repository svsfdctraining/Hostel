package com.school.util.bean;

public class YearBean {

	private String value;
	private String label;
	private int intvalue;
	private int intlabel;

	public YearBean() {
	}

	public YearBean(String value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

	public YearBean(int intvalue, int intlabel) {
		super();
		this.intvalue = intvalue;
		this.intlabel = intlabel;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getIntvalue() {
		return intvalue;
	}

	public void setIntvalue(int intvalue) {
		this.intvalue = intvalue;
	}

	public int getIntlabel() {
		return intlabel;
	}

	public void setIntlabel(int intlabel) {
		this.intlabel = intlabel;
	}

}

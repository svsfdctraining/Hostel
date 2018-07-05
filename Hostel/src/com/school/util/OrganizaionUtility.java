package com.school.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.school.util.bean.YearBean;

public class OrganizaionUtility {

	public static List<YearBean> getYears(){

		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<YearBean> years = new ArrayList<YearBean>();
		for(int i=1900;i<=year;i++){
					years.add(new YearBean(new Integer(i).toString(), new Integer(i).toString()));
				}
		return years;
	}
	
	public static List<YearBean> getIntYears(){

		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<YearBean> years = new ArrayList<YearBean>();
		for(int i=1900;i<=year;i++){
					years.add(new YearBean(i, i));
				}
		return years;
	}
	
	public static List<String> getOrgStatus(){
		List<String> status = new ArrayList<String>();
		status.add("Active");
		status.add("Inactive");
		return status;
	}
}

package com.school.bean;

import java.util.List;

import com.school.pojo.Hostel;
import com.school.pojo.Organization;

public class HostelBean {

	private String orgname;
	private List<Hostel> hostels;
	private List<Organization> organizations;

	public HostelBean() {
		// TODO Auto-generated constructor stub
	}

	public HostelBean(String orgname, List<Hostel> hostels, List<Organization> organizations) {
		super();
		this.orgname = orgname;
		this.hostels = hostels;
		this.organizations = organizations;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public List<Hostel> getHostels() {
		return hostels;
	}

	public void setHostels(List<Hostel> hostels) {
		this.hostels = hostels;
	}

}

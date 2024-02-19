package com.javaex.vo;

public class PersonVo {
	
	private int personId;
	private String name;
	private String ph;
	private String company;
	
	
	public PersonVo() {
		super();
	}
	public PersonVo(String name, String ph, String company) {
		super();
		this.name = name;
		this.ph = ph;
		this.company = company;
	}
	public PersonVo(int personId, String name, String ph, String company) {
		super();
		this.personId = personId;
		this.name = name;
		this.ph = ph;
		this.company = company;
	}
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	@Override
	public String toString() {
		return "PersonVo [personId=" + personId + ", name=" + name + ", ph=" + ph + ", company=" + company + "]";
	}
	
	
}

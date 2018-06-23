package com.alibaba.jdbcinstance;

public class Student {

	//1. ÀΩ”– Ù–‘
	private int sid;
	private String name;
	private int age;
	private String gender;
	
	// 2. get/set£®constructor£©
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}

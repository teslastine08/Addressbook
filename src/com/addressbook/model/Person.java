package com.addressbook.model;
public class Person{

	private String name;
	private String email;
	private String city;
	long mobileno;
	int zip;

	public void setname(String name){
		this.name = name;
	}
	public void setemail(String email){
		this.email = email;
	}
	public void setcity(String city){
		this.city = city;
	}
	public void setmobileno(long mobileno){
		this.mobileno = mobileno;
	}
	public void setzip(int zip){
		this.zip = zip;
	}


	public String getname(){
		return this.name;
	}
	public String getemail(){
		return this.email;
	}
	public String getcity(){
		return this.city;
	}
	public long getmobileno(){
		return this.mobileno;
	}
	public int getzip(){
		return this.zip;
	}
}

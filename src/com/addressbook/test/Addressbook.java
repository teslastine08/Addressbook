package com.addressbook.test;
import com.addressbook.model.Person;

public class Addressbook
{
	public static void main(String[] args)
	{
		Person newPerson = new Person();
		newPerson.setname("Ankan");
		newPerson.setemail("ankansinha1@gmail.com");
		newPerson.setcity("Durgapur");
		newPerson.setmobileno(12345);
		newPerson.setzip(713212);

		System.out.println("NAME: "+newPerson.getname());
		System.out.println("E-mail: "+newPerson.getemail());
		System.out.println("CITY: "+newPerson.getcity());
		System.out.println("MOBILE No.: "+newPerson.getmobileno());
		System.out.println("ZIP CODE: "+newPerson.getzip());
	}
}

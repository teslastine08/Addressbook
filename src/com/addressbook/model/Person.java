package com.addressbook.model;
//import com.addressbook.model.Address;


import java.lang.Comparable;
import java.io.Serializable;

public class Person implements Comparable<Person>,Serializable
{
        private static final long serialVersionUID = 1L;
        String firstName;
        String lastName;
        Address address;
        String phoneNumber;
                Person(){}
                Person(String firstName, String lastName,Address address, String phoneNumber)
                {
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.address = address;
                        this.phoneNumber = phoneNumber;
                }

                public String getFirstName()
                {
                        return this.firstName;
                }

                public void setFirstName( String firstName)
                {
                         this.firstName = firstName;
                }

                public String getLastName()
                {
                        return this.lastName;
                }

                public void setLastName( String lastName)
               {
                         this.lastName = lastName;
               }

                public Address getAddress()
                {
                        return this.address;
                }


                public void setAddress(Address address)
                {
                        this.address = address;
                }

                public String getPhoneNumber()
                {
                        return this.phoneNumber;
                }
		public void setPhoneNumber(String phoneNumber)
                {
                        this.phoneNumber = phoneNumber;

                }

                public String toString()
                {
                        return this.firstName +" "+ this.lastName +"\n"+ this.phoneNumber +"\n"+ this.address.toString();
                }

                public int compareTo(Person person)
                {
                        if(this.address.getZip() > person.address.getZip())
                        {
                                return 1;
                        }
                        if(this.address.getZip() < person.address.getZip())
                        {
                                return -1;
                        }
                        return 0;

                }
}

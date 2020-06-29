package com.addressbook.model;  


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Comparator;
import java.io.Serializable;

public class AddressBook implements Serializable
{
         private static final long serialVersionUID = 1L;
        private String addressBookName;
        List<Person> personList = new ArrayList<Person>();
        Scanner sc = new Scanner(System.in);

       public AddressBook(String addressBookName)
        {
                this.addressBookName=addressBookName;
        }

        public List<Person> getPersonList()
        {
                return this.personList;
        }

        public void addPerson(Person newPer)
        {
                if(newPer==null)
                {
                        newPer=new Person();
                        newPer.setAddress(new Address());

                        System.out.print("FirstName:");
                        newPer.setFirstName(sc.next());

                        System.out.print("LastName:");
                        newPer.setLastName(sc.next());

                        System.out.print("Address Line1 :");
                        newPer.getAddress().setAddressLine1(sc.next());

                        System.out.print("Address Line2 :");
                        newPer.getAddress().setAddressLine2(sc.next());

                        System.out.print("City:");
                        newPer.getAddress().setCity(sc.next());

                        System.out.print("State:");
                        newPer.getAddress().setState(sc.next());

                        System.out.print("Zip:");
                        newPer.getAddress().setZip(sc.nextLong());
            
             System.out.print("Phone Number:");
                        newPer.setPhoneNumber(sc.next());

                }
                this.personList.add(newPer);
        }


        public void editPerson(Person editPer)
        {
                System.out.println("Enter the first name of person to edit :");
                String fName = sc.next();
                editPer = this.getPersonFromList(fName);
                if(editPer!=null)
                {
                        System.out.println("New Address Line1");
                        editPer.getAddress().setAddressLine1(sc.next());

                        System.out.println("New Address Line2");
                        editPer.getAddress().setAddressLine2(sc.next());

                        System.out.println("New City");
                        editPer.getAddress().setCity(sc.next());

                        System.out.println("New State");
                        editPer.getAddress().setState(sc.next());

                        System.out.println("New Zip");
                        editPer.getAddress().setZip(sc.nextInt());

                        System.out.println("New Phone Number");
                        editPer.setPhoneNumber(sc.next());

                        System.out.println("Update Successfully!!");
                        return;

                }
                System.out.println("Error:Person you entered does not exists in Address Book");
        }

     public void deletePerson(Person editPer)
        {
                System.out.println("Enter the first name of person to delete :");
                String fName = sc.next();
                editPer = this.getPersonFromList(fName);
                if(editPer!=null)
                {
                        this.personList.remove(editPer);
                                System.out.println("Deleted Successfully");
                                return;

                }
                System.out.println("Error:Person you entered does not exists in Address Book");


        }


        public void sortByFirstName()
        {
                this.personList.sort(Comparator.comparing(e -> e.getFirstName().toLowerCase()));
        }

         public void sortByLastName()
        {
                this.personList.sort(Comparator.comparing(e -> e.getLastName().toLowerCase()));
        }

        public void sortByZipCode()
        {
                Collections.sort(this.personList);
        }

        public Person getPersonFromList(String name)
        {
                for(Person per : this.personList)
                {
                        if(name.equalsIgnoreCase(per.getFirstName()))
                        {
                                return per;
                        }
                }
                return null;
        }

     public void printAddressBookList()
        {
                System.out.println("---------------------------------------------------------------");
                for(Person per : this.personList)
                {
                        System.out.println(per.toString());
                }
                return;
        }
}

package com.addressbook.test;
import com.addressbook.model.Person;
import com.addressbook.model.AddressBook;
import com.addressbook.model.Address;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.*;

public class test
{
        static Scanner userScanner = new Scanner(System.in);
        File file = null;
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        ObjectOutputStream objOutStrm = null;
        ObjectInputStream objInStrm = null;
        AddressBook currentAddressBook = null;

        public  AddressBook getcurrentAddressBook()
        {
                return this.currentAddressBook;
        }

        public void newAddressBook(String addressBookName) throws IOException
        {
                currentAddressBook = new AddressBook(addressBookName);
                file = new File("./" + addressBookName);
                System.out.println(addressBookName +":New File created successfully");
        }
         public void openAddressBook(String addressBookName) throws IOException, ClassNotFoundException
        {
                currentAddressBook =  new AddressBook(addressBookName);
                file = new File("./"+ addressBookName);
                inputStream = new FileInputStream(addressBookName);
                objInStrm = new ObjectInputStream(inputStream);
                boolean count = true;
                while(count)
                {
                        if(inputStream.available()!=0)
                        {
                                Person per  = (Person) objInStrm.readObject();
                                currentAddressBook.addPerson(per);
                        }
                        else
                        {
                                count=false;
                        }
                }
                System.out.println(addressBookName +": File Opened successfully");
        }

        public static int fileMenu()
        {
                System.out.println("************File Menu*******************");
                System.out.println("1.Create New Address Book");
                System.out.println("2. Open Address Book");
                System.out.println("3. Save Address Book");
                System.out.println("4.Exit");
                System.out.println("*************************************");
                System.out.println();
                System.out.println("Enter your choice");
                int fileMenuChoice =  userScanner.nextInt();
                return fileMenuChoice;
        }
         public static int crudMenu()
        {
                System.out.println("============================Address Book Menu======================");
                System.out.println("1. Add Person");
                System.out.println("2. Edit Person");
                System.out.println("3. Delete Person");
                System.out.println("4.Sort By First Name");
                System.out.println("5.Sort By Last Name");
                System.out.println("6. Sort By Zip Code");
                System.out.println("7. Print all enteries");
                System.out.println("8. Exit to file Menu");
                System.out.println("*************************************");
                System.out.println();
                System.out.println("Enter your choice");
                int crudMenuChoice = userScanner.nextInt();
                return crudMenuChoice;

        }
        
         public static void main(String args[]) throws Exception
        {

                try
                {
                        test myManager = new test();
                        String inputAddressBookName = null;
                        while(true)
                        {
                                int fileMenuOption = fileMenu();
                                outerloop:
                                switch(fileMenuOption)
                                {
                                        case 1 :
                                                        System.out.println("Enter First Name:");
                                                        inputAddressBookName = userScanner.next();
                                                        myManager.newAddressBook(inputAddressBookName);
                                                        innerloop:
                                                        while(true)
                                                        {
                                                                int crudMenuOption = crudMenu();
                                                                switch(crudMenuOption)
                                                                {
                                                                        case 1 : myManager.getcurrentAddressBook().addPerson(null);
                                                                        break;
                                                                        case 2 : myManager.getcurrentAddressBook().editPerson(null);
                                                                        break;
                                                                        case 3 : myManager.getcurrentAddressBook().deletePerson(null);
                                                                        break;
                                                                        case 4 : myManager.getcurrentAddressBook().sortByFirstName();
                                                                        break;
                                                                        case 5 : myManager.getcurrentAddressBook().sortByLastName();
                                                                        break;
                                                                        case 6 : myManager.getcurrentAddressBook().sortByZipCode();
                                                                        break;
                                                                        case 7 :  myManager.getcurrentAddressBook().printAddressBookList();
                                                                        break;
                                                                        case 8 :
                                                                        break outerloop;


                                                                }

                                                        }
                                }
                        }

                }

         catch(IOException ex)
                {
                        System.out.println(ex);
                }
        }

}

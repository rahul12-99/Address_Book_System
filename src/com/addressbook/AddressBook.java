package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    /*
     * 1) creating object of arraylist
     * 2) created a method for add contact details
     * 3) created main method and calling add-contact method
     */
    /*
      1) creating object of arraylist
     */
    ArrayList<ContactPerson> list = new ArrayList<>();
    /*
      2) created a method for add contact details
     */
    public void addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much contact you want to add");
        int noOfContact = sc.nextInt();
        // Taking for loop for add multiple contact details
        for (int i = 1; i <= noOfContact; i++) {
            ContactPerson contact = new ContactPerson();
            System.out.println("Enter first name of " + i + " contact ");
            contact.setFirstName(sc.next());
            System.out.println("Enter last name " + i + " contact ");
            contact.setLastName(sc.next());
            System.out.println("Enter address " + i + " contact ");
            contact.setAddress(sc.next());
            System.out.println("Enter city " + i + " contact ");
            contact.setCity(sc.next());
            System.out.println("Enter state " + i + " contact ");
            contact.setState(sc.next());
            System.out.println("Enter zip " + i + " contact ");
            contact.setZip(sc.nextInt());
            System.out.println("Enter phone number " + i + " contact ");
            contact.setPhoneNumber(sc.nextLong());
            System.out.println("Enter email " + i + " contact ");
            contact.setEmail(sc.next());

            // Adding details in arraylist
            list.add(contact);
        }
        System.out.println(list);
    }
    /*
      3) created main method and calling add-contact method
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
    }
}

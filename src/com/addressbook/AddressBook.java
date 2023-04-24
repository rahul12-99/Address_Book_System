package com.addressbook;

import java.util.Scanner;

public class AddressBook {
    /*
     * Method for creating a contact
     * @param args
     */
    public static void main(String[] args) {
        /*
         * 1) Taking user input for contact details and set the details in contact class
         * 2) Get the details form contact class and printing them
         */
        /*
         1) Taking user input for contact details and set the details in contact class
         */
        ContactPerson contact = new ContactPerson();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book");
        System.out.println("Enter first name");
        contact.setFirstName(sc.next());
        System.out.println("Enter last name");
        contact.setLastName(sc.next());
        System.out.println("Enter address");
        contact.setAddress(sc.next());
        System.out.println("Enter city");
        contact.setCity(sc.next());
        System.out.println("Enter state");
        contact.setState(sc.next());
        System.out.println("Enter zip");
        contact.setZip(sc.nextInt());
        System.out.println("Enter phone number");
        contact.setPhoneNumber(sc.nextLong());
        System.out.println("Enter email");
        contact.setEmail(sc.next());
        /*
         2) Get the details form contact class and printing them
         */
        System.out.println("your contact is : " + " firstName " + contact.getFirstName() + " lastName " + contact.getLastName() +
                " address " + contact.getAddress() + " city " + contact.getCity() + " state " + contact.getState() +
                " Zip " + contact.getZip() + " phoneNumber " + contact.getPhoneNumber() + " email " + contact.getEmail());
    }
}

package com.addressbook;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {
    /*
     ******* Added Two file one for read the object and one for write one method
     *       added for read the file ********
     * 1) creating object of arraylist
     * 2) created method for add contact details
     * 3) created method for edit contact details
     * 4) created method for delete contact details
     * 5) created method for search person details by state
     * 6) created main method and calling all the method
     */
    /*
      1) creating object of arraylist
     */
    ArrayList<ContactPerson> list = new ArrayList<>();
    File file1 = new File("AddressBookStore.txt");
    File file2 = new File("AddressObj.txt");

    ObjectInputStream objectInputStreamReader  = null;
    ObjectOutputStream objectOutputStream = null;
    OutputStreamWriter outputStreamWriter = null;

    /*
      2) created a method for add contact details
     */
    public void addContact() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how much contact you want to add");
        int noOfContact = sc.nextInt();
        // Taking for loop for add multiple contact details
        for (int i = 1; i <= noOfContact; i++) {
            ContactPerson contact = new ContactPerson();
            System.out.println("Enter first name of " + i + " contact ");
            contact.setFirstName(sc.next());
            /*
             * Here taking optional reference variable for checking the duplicate.
             */
            Optional<ContactPerson> ref_var = list.stream()
                    .filter(name -> name.getFirstName().equals(contact.getFirstName())).findAny();
            if (ref_var.isPresent()) {
                System.out.println("Name already exist");
                return;
            }
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
            //  writes the data
            objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file2.toPath()));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            // readable format
            outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(file1.toPath()));
            outputStreamWriter.write(list.toString());
            outputStreamWriter.close();
            list.forEach(System.out::println);
        }
//        System.out.println(list);
    }
        public void readFile(){
        if(file1.isFile()){
            try {
                objectInputStreamReader = new ObjectInputStream(Files.newInputStream(file1.toPath()));
                list = (ArrayList<ContactPerson>) objectInputStreamReader.readObject();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /*
     3) created method for edit contact details
     */
    public void editContact() {
        System.out.println("Please enter first name whose details you want to edit!");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for (ContactPerson person : list) {
            if (name.equals(person.getFirstName())) {
                System.out.println("Enter First name to update");
                person.setFirstName(sc.next());
                System.out.println("Enter Last name to  update");
                person.setLastName(sc.next());
                System.out.println("Enter Address to  update");
                person.setAddress(sc.next());
                System.out.println("Enter City to update");
                person.setCity(sc.next());
                System.out.println("Enter State to update");
                person.setState(sc.next());
                System.out.println("Enter Zip to update");
                person.setZip(sc.nextInt());
                System.out.println("Enter Phone number to update");
                person.setPhoneNumber(sc.nextLong());
                System.out.println("Enter Email to update");
                person.setEmail(sc.next());
            } else {
                System.out.println("Enter contact details not available");
            }
        }
        System.out.println(list);
    }

    /*
     4) created method for delete contact details
     */
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first name to delete contact");
        String name = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getFirstName())) {
                list.remove(i);
                break;
            } else {
                System.out.println("Contact details not available");
            }
        }
        System.out.println(list);
    }

    /**
     5)This method is for search person details by state
     */
    public void searchPersonDetails() {
        System.out.println("Enter the name of state:");
        Scanner sc = new Scanner(System.in);
        String stateName = sc.next();
        List<ContactPerson> ref_var = list.stream()
                .filter(state -> state.getState().equals(stateName)).collect(Collectors.toList());
        for (ContactPerson contactPerson : ref_var) {
            System.out.println("Details are: " + contactPerson);
        }
    }

    /*
      6) created method to calling all the method
     */
    public void callAddressBook() throws Exception {
        readFile();
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("-*-*-*-Welcome to Address Book-*-*-*-");
            System.out.println("Enter choice which you want to perform");
            System.out.println("Enter 1 to add contact");
            System.out.println("Enter 2 to edit contact");
            System.out.println("Enter 3 to delete contact");
            System.out.println("Enter 4 to search contact by state");
            System.out.println("Enter 5 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    searchPersonDetails();
                    break;
                default:
                    b = false;
            }
        }
    }
}

package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookDictionary {
    /**
     * 1) Using hashmap for creating multiple addressBook
     * 2) Taking scanner class for user input in each method, creating object reference of addressBook class
     * 3) created method for add new addressBook
     * 4) created method for display addressBook
     * 5) created method for select and perform operation on addressBook
     * 6) created method for delete addressBook
     * 7) created method for view contact by city
     * 8) created method for get no of contact by city
     * 9) created method for get no of contact by city
     * 10) created method for sort by city state and zip
     * 11) created main method for calling all the method
     */
    // 1) Using hashmap for creating multiple addressBook
    Map<String, AddressBook> map = new HashMap<>();
    // 2) Taking scanner class for user input in each method, creating object reference of addressBook class
    Scanner scanner = new Scanner(System.in);
    AddressBook addressBook = new AddressBook();

    /*
     * 3) created method for add new addressBook
     */
    public void addAddressBook() {
        System.out.println("Enter the name to add address book");
        String newBookName = scanner.next();
        map.put(newBookName, addressBook);
        System.out.println(newBookName);
    }

    /*
     * 4) created method for display addressBook
     */
    public void displayAddressBook() {
        for (String addressBookName : map.keySet()) {
            System.out.println(addressBookName);
        }
    }

    /*
     * 5) created method for select and perform operation on addressBook
     */
    public void selectAddressBook() {
        displayAddressBook();
        System.out.println("Select name of addressBook!");
        String inputName = scanner.next();
        for (String key : map.keySet()) {
            if (inputName.equals(key)) {
                map.get(inputName).callAddressBook();
            } else {
                System.out.println("Selected name not found!");
            }
        }
    }

    /*
     * 6) created method for delete addressBook
     */
    public void deleteAddressBook() {
        displayAddressBook();
        System.out.println("Select name to delete addressBook!");
        String inputName = scanner.next();
        for (String key : map.keySet()) {
            if (inputName.equals(key)) {
                map.remove(key);
            } else {
                System.out.println("Selected name not found!");
            }
        }
    }

    /*
     * 7) created method for view contact by city
     */
    public void viewContactsWithCity() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter city name");
        String cityName = input.next();
        List<ContactPerson> listOfContacts = map.values().stream().flatMap(p ->
                p.list.stream()).filter(p -> p.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList());
        System.out.println(listOfContacts);
    }

    /*
     * 8) created method for get no of contact by city
     */
    public void getNumberContacts() {
        System.out.println("Please enter city name");
        String cityName = scanner.next();
        long count = map.values().stream().flatMap(p -> p.list.stream()).filter(p -> p.getCity().equalsIgnoreCase(cityName)).count();
        System.out.println("Count of contacts with " + cityName + " are " + count);
    }

    /*
     * 9) created method for get no of contact by city
     */
    public void getSortedContactByName() {
        List<ContactPerson> nameSortedAddressBook = map.values().stream().flatMap(A -> A.list.stream())
                .sorted((Comparator.comparing(ContactPerson::getFirstName))).collect(Collectors.toList());
        System.out.println(nameSortedAddressBook);
    }
    /*
     * 10) created method for sort by city state and zip
     */
    public void getSortedContacts() {
        System.out.println("Please enter the choice parameter by which you want sort");
        System.out.println("Press 1 for Name" + '\n' + "Press 2 for City" + '\n' + "Press 3 for State" + '\n' + "Press 4 for ZipCode");
        final int byName = 1, byCity = 2, byState = 3, byZipCode = 4;
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case byName:
                System.out.println(map.values().stream().flatMap(N -> N.list.stream())
                        .sorted((Comparator.comparing(ContactPerson::getFirstName))).collect(Collectors.toList()));
                break;
            case byCity:
                System.out.println(map.values().stream().flatMap(C -> C.list.stream())
                        .sorted((Comparator.comparing(ContactPerson::getCity))).collect(Collectors.toList()));
                break;
            case byState:
                System.out.println(map.values().stream().flatMap(S -> S.list.stream())
                        .sorted((Comparator.comparing(ContactPerson::getState))).collect(Collectors.toList()));
                break;
            case byZipCode:
                System.out.println(map.values().stream().flatMap(Z -> Z.list.stream())
                        .sorted((Comparator.comparing(ContactPerson::getZip))).collect(Collectors.toList()));
                break;
            default:
                System.out.println("You entered wrong input");
        }
    }

    /*
     * 11) created main method for calling all the method
     */
    public static void main(String[] args) {
        System.out.println("-*-*-*-*-*-Welcome To AddressBookDictionary-*-*-*-*-*-");
        AddressBookDictionary addressBookMain = new AddressBookDictionary();
        boolean b = true;
        while (b) {
            System.out.println("Enter what you want to perform!");
            System.out.println("Enter 1 for add addressBook!");
            System.out.println("Enter 2 for operation on addressBook!");
            System.out.println("Enter 3 for delete addressBook!");
            System.out.println("Enter 4 for display addressBook!");
            System.out.println("Enter 5 for search contact by city");
            System.out.println("Enter 6 to get no of contact");
            System.out.println("Enter 7 to short the contact");
            System.out.println("Enter 8 to sort contact by city,state,and zip");
            System.out.println("Enter 9 for exit from addressBook!");
            Scanner scanner1 = new Scanner(System.in);
            int choice = scanner1.nextInt();

            switch (choice) {
                case 1:
                    addressBookMain.addAddressBook();
                    break;
                case 2:
                    addressBookMain.selectAddressBook();
                    break;
                case 3:
                    addressBookMain.deleteAddressBook();
                    break;
                case 4:
                    addressBookMain.displayAddressBook();
                    break;
                case 5:
                    addressBookMain.viewContactsWithCity();
                    break;
                case 6:
                    addressBookMain.getNumberContacts();
                    break;
                case 7:
                    addressBookMain.getSortedContactByName();
                    break;
                case 8:
                    addressBookMain.getSortedContacts();
                default:
                    b = false;
            }
        }
    }
}


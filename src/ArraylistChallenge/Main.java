package ArraylistChallenge;

import java.util.Scanner;

//issue doesn't avoid from duplicate contact during adding and update
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone("0093781123456");

    public static void main(String[] args) {

        startPhone();
        printActions();
        boolean quit = false;
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Shut down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateCotnact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }
        }

    }


    private static void addNewContact() {
        String name, number;
        System.out.print("Name:");
        name = scanner.nextLine();
        System.out.print("Phone Number:");
        number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);

        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added, name:" + name + " phone number:" + number);
        } else {
            System.out.println("Cannot add, " + name + " is already exist");
        }
    }

    private static void updateCotnact() {
        String name, phoneNumber, searchContact;
        System.out.println("Enter existing contact name::");
        searchContact = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(searchContact);
        if (existingContact == null) {
            System.out.println("Contact is not exist");
            return;
        }

        System.out.println("New Name:");
        name = scanner.nextLine();
        System.out.println("New phone number:");
        phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (mobilePhone.updateContact(searchContact, newContact)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Error updating contact");
        }


    }


    private static void removeContact() {
        String searchContact;
        System.out.println("Enter existing contact name::");
        searchContact = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(searchContact);
        if (existingContact == null) {
            System.out.println("Contact is not exist");
            return;
        }

        if (mobilePhone.removeCotnact(existingContact)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }

    }

    private static void queryContact() {
        String searchContact;
        System.out.println("Enter existing contact name::");
        searchContact = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(searchContact);
        if (existingContact == null) {
            System.out.println("Contact is not exist");
            return;
        }

        System.out.printf("The name is:" + existingContact.getName() + " and phone number:" + existingContact.getNumber());
    }



    private static void startPhone() {
        System.out.println("Starting the Phone");
    }

    private static void printActions() {
        System.out.println("0 - To shut down the phone");
        System.out.println("1 - To print contacts");
        System.out.println("2 - To add a new contact");
        System.out.println("3 - To update an existing contact");
        System.out.println("4 - To remove a contact");
        System.out.println("5 - Query if an existing contact exists");
        System.out.println("6 - To print the list of available actions");
    }
}

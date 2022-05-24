package ArraylistChallenge;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        int isExist = findContact(contact);
        System.out.println(isExist);
        if (findContact(contact) >= 0) {
            System.out.println("Contact is already exist");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public boolean updateContact(String oldContactName, Contact newContact) {
        int foundPosition = findContact(oldContactName);
        System.out.println(foundPosition);
        if (foundPosition < 0) {
            System.out.println(oldContactName + " is not found");
            return false;
        } else if (findContact(newContact) != -1) {
            System.out.println("The contact:" + newContact.getNumber() + " is already exist," +
                    "update failed");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContactName + " has been replaced with " + newContact.getName());
        return true;
    }

    public boolean removeCotnact(Contact contact) {
        int foundPosition = findContact(contact);

        if (foundPosition < 0) {
            System.out.println(contact.getName() + " is not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println("\t" + (i + 1) + "." + this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getNumber());
        }
    }
}

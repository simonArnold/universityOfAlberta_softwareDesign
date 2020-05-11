package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ContactListController {

    private ContactList contactList;

    public ContactListController(ContactList contactList) {
        this.contactList = contactList;
    }

    public void loadContacts(Context context) {
        contactList.loadContacts(context);
    }

    // ======================================
    // Methods to manipulate the contact list
    // NOTE: I changed some of the parameters here. Makes more sense to me this way and is simpler.
    // ======================================

    public boolean addContact(String username, String email, Context context) {
        Contact newContact = new Contact(username, email, null);
        AddContactCommand add_contact_command = new AddContactCommand(contactList, newContact, context);
        add_contact_command.execute();
        return add_contact_command.isExecuted();
    }

    public boolean deleteContact(int atPosition, Context context) {
        Contact contact = contactList.getContact(atPosition);
        DeleteContactCommand delete_contact_command = new DeleteContactCommand(contactList, contact, context);
        delete_contact_command.execute();
        return delete_contact_command.isExecuted();
    }

    public boolean editContact(int atPosition, String newUsername, String newEmail, Context context) {
        Contact oldContact = contactList.getContact(atPosition);
        Contact updatedContact = new Contact(newUsername, newEmail, oldContact.getId());
        EditContactCommand edit_contact_command = new EditContactCommand(contactList, oldContact, updatedContact, context);
        edit_contact_command.execute();
        return edit_contact_command.isExecuted();
    }

    // ======================================
    // Methods to query the contact list
    // ======================================

    public Contact getContactByUsername(String username) {
        return contactList.getUserByUsername(username);
    }

    public void setContacts(ArrayList<Contact> contacts) {
        contactList.setContacts(contacts);
    }

    public int getSize() {
        return contactList.getSize();
    }
    public List<String> getAllUsernames() {
        return contactList.getAllUsernames();
    }
    public int getIndex(Contact contact) {
        return contactList.getIndex(contact);
    }
    public ContactController getContactController(int atPosition) {
        return new ContactController(contactList.getContact(atPosition));
    }
    public boolean isUsernameAvailable(String username) {
        return contactList.isUsernameAvailable(username);
    }
    public boolean hasContact(Contact contact) {
        return contactList.hasContact(contact);
    }
    public ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    // ======================================
    // Observer methods
    // ======================================

    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }
}

package com.example.sharingapp;

public class ContactController {

    private Contact contact;

    public ContactController(Contact contact) {
        this.contact = contact;
    }

    // ======================================
    // Methods to query the contact list
    // ======================================

    public String getId() {
        return contact.getId();
    }
    public String getUsername() {
        return contact.getUsername();
    }
    public String getEmail() {
        return contact.getEmail();
    }

    // ======================================
    // Observer methods
    // ======================================

    public void addObserver(Observer observer) {
        contact.addObserver(observer);
    }
    public void removeObserver(Observer observer) {
        contact.removeObserver(observer);
    }
}

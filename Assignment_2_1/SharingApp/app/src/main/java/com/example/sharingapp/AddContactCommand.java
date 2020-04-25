package com.example.sharingapp;

import android.content.Context;

public class AddContactCommand extends Command {

    private ContactList contactList;
    private Contact contact;
    private Context context;

    public AddContactCommand(ContactList contactList, Contact contact, Context context) {
        this.contactList = contactList;
        this.contact = contact;
        this.context = context;
    }

    @Override
    public void execute() {
        contactList.addContact(contact);
        boolean success = contactList.saveContacts(context);
        setIsExecuted(success);
    }
}

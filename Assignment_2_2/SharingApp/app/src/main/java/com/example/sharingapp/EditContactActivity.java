package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Editing a pre-existing contact consists of deleting the old contact and adding a new contact with the old
 * contact's id.
 * Note: You will not be able contacts which are "active" borrowers
 */
public class EditContactActivity extends AppCompatActivity implements Observer {

    private ContactController contactController;
    private ContactListController contactListController = new ContactListController(new ContactList());
    private EditText email;
    private EditText username;
    private Context context;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contactListController.loadContacts(context);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        contactController = contactListController.getContactController(pos);
        contactListController.addObserver(this);
        contactController.addObserver(this);
        update();
    }

    public void saveContact(View view) {

        String email_str = email.getText().toString();

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        if (!email_str.contains("@")){
            email.setError("Must be an email address!");
            return;
        }

        String username_str = username.getText().toString();

        // Check that username is unique AND username is changed (Note: if username was not changed
        // then this should be fine, because it was already unique.)
        if (!contactListController.isUsernameAvailable(username_str)) {
            username.setError("Username already taken!");
            return;
        }

        contactListController.removeObserver(this);
        boolean success = contactListController.editContact(pos, username_str, email_str, context);
        if (!success){
            return;
        }

        // End EditContactActivity
        finish();
    }

    public void deleteContact(View view) {
        contactListController.removeObserver(this);
        boolean success = contactListController.deleteContact(pos, context);
        if (!success){
            return;
        }

        // End EditContactActivity
        finish();
    }

    @Override
    public void update() {
        contactController = contactListController.getContactController(pos);
        username.setText(contactController.getUsername());
        email.setText(contactController.getEmail());
    }
}

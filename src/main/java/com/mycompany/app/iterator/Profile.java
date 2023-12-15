package com.mycompany.app.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
    private String name;
    private String email;
    private Map<String, List<String>> contacts = new HashMap<>();

    public Profile(String email, String name, String... contacts) {
        this.email = email;
        this.name = name;

        /*
        * Parse and categorize contact information into a map, where each key is a contact type (like "friend")
        * and the value is a list of email addresses associated with that contact type.
        * If a contact type is not specified in the input, "friend" is used as a default type.
        * */
        for (String contact: contacts) {
            String[] parts = contact.split(":");
            String contactType = "friend", contactEmail;

            /*
            * If the split operation results in only one part, it's assumed that the string
            * contains only the contact's email address. The contact type defaults to "friend".
            * */
            if (parts.length == 1) {
                contactEmail = parts[0];
            }
            else { // If there are two parts, the first part is the contact type, and the second part email address.
                contactType = parts[0];
                contactEmail = parts[1];
            }
            if (!this.contacts.containsKey(contactType)) {
                this.contacts.put(contactType, new ArrayList<>());
            }
            this.contacts.get(contactType).add(contactEmail);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<String> getContacts(String contactType) {
        if (!this.contacts.containsKey(contactType)) {
            this.contacts.put(contactType, new ArrayList<>());
        }
        return contacts.get(contactType);
    }
}

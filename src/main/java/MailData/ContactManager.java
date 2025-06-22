package MailData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private static final String CONTACTS_FILE = "contacts.txt";
    private static List<Contact> contacts = new ArrayList<>();

    static {
        loadContacts();
    }

    private static void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contact contact = Contact.fromFileString(line);
                if (contact != null) {
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {

        }
    }

    public static List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
        saveContactToFile(contact);
    }

    private static void saveContactToFile(Contact contact) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTACTS_FILE, true))) {
            writer.write(contact.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
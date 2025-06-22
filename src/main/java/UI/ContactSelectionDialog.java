package UI;

import MailData.Contact;
import MailData.ContactManager;
import UI.Buttons.AddButton;
import UI.Buttons.CancelButton;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ContactSelectionDialog extends JDialog {
    private JList<Contact> contactJList;
    private DefaultListModel<Contact> contactListModel;
    private Contact selectedContact;

    public ContactSelectionDialog(Frame owner) {
        super(owner, "Select Contact", true);
        setSize(400, 400);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        contactListModel = new DefaultListModel<>();
        contactJList = new JList<>(contactListModel);
        contactJList.setFont(new Font("Arial", Font.PLAIN, 16));
        contactJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(contactJList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        AddButton selectButton = new AddButton();
        selectButton.setText("Select");
        selectButton.addActionListener(e -> {
            selectedContact = contactJList.getSelectedValue();
            dispose();
        });

        CancelButton cancelButton = new CancelButton();
        cancelButton.addActionListener(e -> {
            selectedContact = null;
            dispose();
        });

        buttonPanel.add(selectButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadContacts();
    }

    private void loadContacts() {
        contactListModel.clear();
        List<Contact> contacts = ContactManager.getContacts();
        for (Contact contact : contacts) {
            contactListModel.addElement(contact);
        }
    }

    public Contact getSelectedContact() {
        return selectedContact;
    }
}
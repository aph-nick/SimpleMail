package UI;

import MailData.Contact;
import MailData.ContactManager;
import MailData.EmailCheck;
import UI.Buttons.AddButton;
import UI.Buttons.CancelButton;
import UI.TextFields.NameField;
import UI.TextFields.LastNameField;
import UI.TextFields.EmailField;
import javax.swing.*;
import java.awt.*;

public class AddContactFrame extends JFrame {
    private NameField firstNameFieldComponent;
    private LastNameField lastNameFieldComponent;
    private EmailField emailFieldComponent;
    private AddButton addButton;
    private CancelButton cancelButton;

    public AddContactFrame() {
        setTitle("Add a new Contact");
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);

        firstNameFieldComponent = new NameField();
        lastNameFieldComponent = new LastNameField();
        emailFieldComponent = new EmailField();

        addButton = new AddButton();
        cancelButton = new CancelButton();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(firstNameFieldComponent, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lastNameFieldComponent, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(emailFieldComponent, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(buttonPanel, gbc);

        add(panel);

        addButton.addActionListener(e -> addContact());
        cancelButton.addActionListener(e -> dispose());
    }

    private void addContact() {
        String firstName = firstNameFieldComponent.getField().getText().trim();
        String lastName = lastNameFieldComponent.getField().getText().trim();
        String email = emailFieldComponent.getField().getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!EmailCheck.checkEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Contact newContact = new Contact(firstName, lastName, email);
            ContactManager.addContact(newContact);
            JOptionPane.showMessageDialog(this, "Contact added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
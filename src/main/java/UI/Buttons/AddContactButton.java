package UI.Buttons;

import javax.swing.*;

public class AddContactButton extends JButton {
    ImageIcon contactIcon = new ImageIcon(getClass().getResource("/addcontact.jpg"));

    public AddContactButton() {
        super("Add Contact");
        setIcon(contactIcon);
    }
}

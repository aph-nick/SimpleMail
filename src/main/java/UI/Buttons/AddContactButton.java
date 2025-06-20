package UI.Buttons;

import javax.swing.*;
import java.awt.*;

public class AddContactButton extends JButton {
    ImageIcon contactIcon = new ImageIcon(getClass().getResource("/addcontact.jpg"));

    public AddContactButton() {
        super("Add Contact");
        setSize(contactIcon.getIconWidth(), contactIcon.getIconHeight());
        setBorder(new RoundedBorder(20));
        setIcon(contactIcon);
        setBackground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 15));
    }
}

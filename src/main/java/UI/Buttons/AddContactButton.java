package UI.Buttons;

import UI.AddContactFrame;
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
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addActionListener(e -> {
            AddContactFrame addContactFrame = new AddContactFrame();
            addContactFrame.setVisible(true);
        });
    }
}
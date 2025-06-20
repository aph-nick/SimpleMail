package UI.Buttons;

import javax.swing.*;
import java.awt.*;

public class SendMailButton extends JButton {
    ImageIcon mailIcon = new ImageIcon(getClass().getResource("/addmail.jpg"));

    public SendMailButton() {
        super("Send Mail");
        setSize(mailIcon.getIconWidth(), mailIcon.getIconHeight());
        setIcon(mailIcon);
        setBorder(new RoundedBorder(20));
        setBackground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 15));
    }
}

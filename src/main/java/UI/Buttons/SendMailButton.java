package UI.Buttons;

import javax.swing.*;

public class SendMailButton extends JButton {
    ImageIcon mailIcon = new ImageIcon(getClass().getResource("/addmail.jpg"));

    public SendMailButton() {
        super("Send Mail");
        setIcon(mailIcon);
    }
}

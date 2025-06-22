package UI.Buttons;

import UI.Panels.LeftPanel.LeftPanel;
import UI.SendMailFrame;

import javax.swing.*;
import java.awt.*;

public class SendMailButton extends JButton {
    ImageIcon mailIcon = new ImageIcon(getClass().getResource("/addmail.jpg"));
    private LeftPanel leftPanelRef;

    public SendMailButton(LeftPanel leftPanel) {
        super("Send Mail");
        this.leftPanelRef = leftPanel;

        setSize(mailIcon.getIconWidth(), mailIcon.getIconHeight());
        setIcon(mailIcon);
        setBorder(new RoundedBorder(20));
        setBackground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 15));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addActionListener(e -> {
            SendMailFrame sendMailFrame = new SendMailFrame(leftPanel);
            sendMailFrame.setVisible(true);
        });
    }
}

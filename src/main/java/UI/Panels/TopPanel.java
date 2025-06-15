package UI.Panels;

import UI.Buttons.AddContactButton;
import UI.Buttons.SendMailButton;
import UI.Clock.ClockDisplay;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    public TopPanel() {
        setLayout(new BorderLayout());
        add(new AddContactButton(), BorderLayout.WEST);
        add(new SendMailButton(), BorderLayout.CENTER);
        add(new ClockDisplay(), BorderLayout.EAST);
    }
}

package UI.Panels;

import UI.Buttons.SendMailButton;
import UI.TextArea.MailContentArea;
import UI.TextFields.SendToField;
import UI.TextFields.TopicField;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new SendToField());
        add(new TopicField());

        MailContentArea mailContent = new MailContentArea();
        JScrollPane scrollPane = new JScrollPane(mailContent);
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        add(scrollPane);

    }
}

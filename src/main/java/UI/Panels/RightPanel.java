package UI.Panels;

import MailData.Message;
import UI.Listeners.MailSelectionListener;
import UI.TextArea.MailContentArea;
import UI.TextFields.EmailField;
import UI.TextFields.TopicField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RightPanel extends JPanel implements MailSelectionListener {

    private EmailField emailField;
    private TopicField topicField;
    private MailContentArea mailContentArea;

    public RightPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        emailField = new EmailField();
        emailField.setEditable(false);
        emailField.setFieldBackground(Color.WHITE);
        add(emailField);

        topicField = new TopicField();
        topicField.setEditable(false);
        add(topicField);

        mailContentArea = new MailContentArea();
        mailContentArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mailContentArea);
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        add(scrollPane);

        setExampleText();
    }

    private void setExampleText() {
        emailField.setText("example@example.com");
        emailField.setFieldBackground(Color.WHITE);
        topicField.setText("Example Mail Topic");
        mailContentArea.setText("Hello! This is an example mail content.\n\n" +
                "You can select an email from the left panel to view its details here.");
    }

    @Override
    public void onMailSelected(Message mail) {
        if (mail == null) {
            setExampleText();
            return;
        }

        String receiver = mail.getReceiver();
        String topic = mail.getTopic();
        String content = mail.getContent();

        emailField.setText(receiver);
        emailField.setFieldBackground(Color.WHITE);
        topicField.setText(topic);
        mailContentArea.setText(content);
    }
}
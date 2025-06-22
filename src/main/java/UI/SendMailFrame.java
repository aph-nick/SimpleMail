package UI;

import MailData.Message;
import MailData.Contact;
import MailData.EmailCheck;
import MailData.MessageManager;
import UI.Buttons.SendButton;
import UI.Buttons.CancelButton;
import UI.Buttons.SelectButton;
import UI.Panels.LeftPanel.LeftPanel;
import UI.TextArea.MailContentArea;
import UI.TextFields.EmailField;
import UI.TextFields.TopicField;
import javax.swing.*;
import java.awt.*;

public class SendMailFrame extends JFrame {
    private EmailField emailField;
    private TopicField topicField;
    private MailContentArea mailContentArea;
    private SendButton sendButton;
    private CancelButton cancelButton;
    private SelectButton selectButton;

    private LeftPanel leftPanelRef;

    public SendMailFrame(LeftPanel leftPanel) {
        this.leftPanelRef = leftPanel;

        setTitle("Compose New Mail");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        emailField = new EmailField();
        topicField = new TopicField();
        mailContentArea = new MailContentArea();

        JPanel sendToPanel = new JPanel(new BorderLayout(5, 0));
        sendToPanel.setBackground(Color.WHITE);
        sendToPanel.add(emailField, BorderLayout.CENTER);
        selectButton = new SelectButton();
        selectButton.addActionListener(e -> openContactSelectionDialog());
        sendToPanel.add(selectButton, BorderLayout.EAST);

        sendButton = new SendButton();
        cancelButton = new CancelButton();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        panel.add(sendToPanel, gbc);

        gbc.gridy = 1;
        panel.add(topicField, gbc);

        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane mailContentScrollPane = new JScrollPane(mailContentArea);
        mailContentScrollPane.setPreferredSize(new Dimension(700, 300));
        mailContentScrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.add(mailContentScrollPane, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(sendButton);
        buttonPanel.add(cancelButton);

        gbc.gridy = 3;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(buttonPanel, gbc);

        add(panel);

        sendButton.addActionListener(e -> sendMail());
        cancelButton.addActionListener(e -> dispose());
    }

    private void openContactSelectionDialog() {
        ContactSelectionDialog dialog = new ContactSelectionDialog(this);
        dialog.setVisible(true);

        Contact selectedContact = dialog.getSelectedContact();
        if (selectedContact != null) {
            emailField.getField().setText(selectedContact.getEmail());
        }
    }

    private void sendMail() {
        String recipientEmail = emailField.getField().getText().trim();
        String topic = topicField.getField().getText().trim();
        String content = mailContentArea.getText().trim();

        if (recipientEmail.isEmpty() || topic.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!EmailCheck.checkEmail(recipientEmail)) {
            JOptionPane.showMessageDialog(this, "Invalid recipient email format.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Message newMessage = new Message(recipientEmail, topic, content);
            MessageManager.addSentMail(newMessage);

            if (leftPanelRef != null) {
                leftPanelRef.addSentMailTopic(newMessage);
            }


            JOptionPane.showMessageDialog(this, "Mail sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
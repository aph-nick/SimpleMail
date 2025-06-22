package UI.Panels;

import MailData.Message;
import UI.Listeners.MailSelectionListener;
import UI.TextArea.MailContentArea;
import UI.TextFields.EmailField;
import UI.TextFields.TopicField;
import javax.swing.*;
import java.awt.*;

public class MailComposePanel extends JPanel implements MailSelectionListener {
    private EmailField emailField;
    private TopicField topicField;
    private MailContentArea mailContentArea;
    private JButton editButton;

    public MailComposePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Compose / View Mail"));


        JPanel headerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        emailField = new EmailField();
        topicField = new TopicField();
        mailContentArea = new MailContentArea();


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        headerPanel.add(emailField, gbc);


        gbc.gridy = 1;
        headerPanel.add(topicField, gbc);


        JScrollPane scrollableMailContent = new JScrollPane(mailContentArea);
        scrollableMailContent.setPreferredSize(new Dimension(500, 300)); // Initial size
        scrollableMailContent.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));


        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        editButton = new JButton("Edit Mail");
        editButton.addActionListener(e -> setFieldsEditable(true));
        controlPanel.add(editButton);


        add(headerPanel, BorderLayout.NORTH);
        add(scrollableMailContent, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setFieldsEditable(true);
    }

    private void setFieldsEditable(boolean editable) {
        emailField.getField().setEditable(editable);
        topicField.getField().setEditable(editable);
        mailContentArea.setEditable(editable);

        Color background = editable ? UIManager.getColor("TextField.background") : Color.WHITE;
        emailField.getField().setBackground(background);
        topicField.getField().setBackground(background);
        mailContentArea.setBackground(background);

        editButton.setVisible(!editable);
    }

    @Override
    public void onMailSelected(Message mail) {
        emailField.getField().setText(mail.getReceiver());
        topicField.getField().setText(mail.getTopic());
        mailContentArea.setText(mail.getContent());
        setFieldsEditable(false);
    }
}
package UI.Panels.LeftPanel;

import MailData.Message;
import MailData.MessageManager;
import UI.Panels.LeftPanel.SentMailsPanel;

import javax.swing.*;
import UI.Listeners.MailSelectionListener;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class LeftPanel extends JPanel {

    private JLabel sentMailsLabel;
    private SentMailsPanel sentMailsPanel;
    private JScrollPane scrollPane;

    public LeftPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 600));
        setBorder(new LineBorder(Color.DARK_GRAY));
        setBackground(Color.white);

        sentMailsLabel = new JLabel("Sent Mails");
        sentMailsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        sentMailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(10));
        add(sentMailsLabel);
        add(Box.createVerticalStrut(5));

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separator.setForeground(Color.GRAY);
        add(separator);
        add(Box.createVerticalStrut(10));

        sentMailsPanel = new SentMailsPanel();

        scrollPane = new JScrollPane(sentMailsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);

        sentMailsPanel.setParentScrollPane(scrollPane);

        add(Box.createVerticalGlue());

        loadAndDisplaySentMails();
    }

    public void addSentMailTopic(Message message) {
        sentMailsPanel.addMailTopic(message);
    }

    public void setMailSelectionListener(MailSelectionListener listener) {
        sentMailsPanel.setMailSelectionListener(listener);
    }

    private void loadAndDisplaySentMails() {
        List<Message> messages = MessageManager.getSentMails(); // Using MailManager
        for (Message message : messages) {
            sentMailsPanel.addMailTopic(message);
        }
    }
}
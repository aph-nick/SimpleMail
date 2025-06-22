package UI.Panels.LeftPanel;

import MailData.Message;
import UI.Listeners.MailSelectionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SentMailsPanel extends JPanel {

    private JScrollPane parentScrollPane;
    private MailSelectionListener mailSelectionListener;

    public SentMailsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
    }

    public void setParentScrollPane(JScrollPane scrollPane) {
        this.parentScrollPane = scrollPane;
    }

    public void setMailSelectionListener(MailSelectionListener listener) {
        this.mailSelectionListener = listener;
    }

    public void addMailTopic(Message email) {
        if (email == null || email.getTopic() == null || email.getTopic().trim().isEmpty()) {
            return;
        }

        JLabel topicLabel = new JLabel(email.getTopic());
        topicLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        topicLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        topicLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        topicLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topicLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mailSelectionListener != null) {
                    mailSelectionListener.onMailSelected(email);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                topicLabel.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                topicLabel.setForeground(Color.BLACK);
            }
        });

        add(topicLabel);

        revalidate();
        repaint();

        if (parentScrollPane != null) {
            SwingUtilities.invokeLater(() -> {
                JScrollBar verticalScrollBar = parentScrollPane.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getMaximum());
            });
        }
    }
}
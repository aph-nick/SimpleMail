package UI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {

        ImageIcon mailIcon = new ImageIcon(getClass().getResource("/addmail.jpg"));
        ImageIcon contactIcon = new ImageIcon(getClass().getResource("/addcontact.jpg"));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        setTitle("SimpleMail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        GridBagConstraints gbc_topPanel = new GridBagConstraints();
        gbc_topPanel.insets = new Insets(10, 10, 10, 10);
        gbc_topPanel.gridy = 0;

        gbc_topPanel.gridx = 0;
        gbc_topPanel.anchor = GridBagConstraints.WEST;

        JButton mailButton = new JButton("Send Mail");
        mailButton.setPreferredSize(new Dimension(200, 100));
        mailButton.setIcon(mailIcon);
        mailButton.setHorizontalTextPosition(SwingConstants.CENTER);
        mailButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        mailButton.setBackground(Color.WHITE);
        mailButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        topPanel.add(mailButton, gbc_topPanel);

        gbc_topPanel.gridx = 1;
        JButton contactButton = new JButton("Add a Contact");
        contactButton.setPreferredSize(new Dimension(200, 100));
        contactButton.setIcon(contactIcon);
        contactButton.setHorizontalTextPosition(SwingConstants.CENTER);
        contactButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        contactButton.setBackground(Color.WHITE);
        contactButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        topPanel.add(contactButton, gbc_topPanel);

        gbc_topPanel.gridx = 2;
        gbc_topPanel.weightx = 1.0;
        gbc_topPanel.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(Box.createHorizontalGlue(), gbc_topPanel);

        JLabel clockLabel = new JLabel("Clock");
        clockLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        gbc_topPanel.gridx = 3;
        gbc_topPanel.anchor = GridBagConstraints.EAST;
        gbc_topPanel.weightx = 0;
        gbc_topPanel.fill = GridBagConstraints.NONE;
        topPanel.add(clockLabel, gbc_topPanel);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.05;
        panel.add(topPanel, gbc);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JLabel wyslaneLabel = new JLabel("Sent Messages::");
        wyslaneLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        leftPanel.add(wyslaneLabel, gbc);

        leftPanel.add(new JButton("placeholder1"));
        leftPanel.add(new JButton("placeholder2"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.95;

        panel.add(leftPanel, gbc);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        GridBagConstraints innerGBC = new GridBagConstraints();

        JLabel adresatLabel = new JLabel("ADRESAT:");
        adresatLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        innerGBC.gridx = 0;
        innerGBC.gridy = 0;
        innerGBC.weightx = 0.15;
        innerGBC.anchor = GridBagConstraints.WEST;
        innerGBC.fill = GridBagConstraints.NONE;
        rightPanel.add(adresatLabel, innerGBC);

        JTextField textField1 = new JTextField();
        textField1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20)); // ustaw czcionkę
        innerGBC.fill = GridBagConstraints.HORIZONTAL;
        innerGBC.gridx = 1;
        innerGBC.gridy = 0;
        innerGBC.weightx = 0.85;
        rightPanel.add(textField1, innerGBC);

        JLabel topicLabel = new JLabel("TOPIC:");
        topicLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        innerGBC.gridx = 0;
        innerGBC.gridy = 1;
        innerGBC.weightx = 0.15;
        innerGBC.anchor = GridBagConstraints.WEST;
        innerGBC.fill = GridBagConstraints.NONE;
        rightPanel.add(topicLabel, innerGBC);

        JTextField textField2 = new JTextField();
        textField2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20)); // ustaw czcionkę
        innerGBC.fill = GridBagConstraints.HORIZONTAL;
        innerGBC.gridx = 1;
        innerGBC.gridy = 1;
        innerGBC.weightx = 0.85;
        rightPanel.add(textField2, innerGBC);

        JTextArea textArea = new JTextArea();
        innerGBC.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(textArea);
        innerGBC.gridx = 0;
        innerGBC.gridy = 2;
        innerGBC.gridwidth = 2;
        innerGBC.weighty = 1;
        rightPanel.add(scrollPane, innerGBC);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.9;
        gbc.weighty = 0.95;
        panel.add(rightPanel, gbc);

        pack();
        setContentPane(panel);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setSize(1200, 800);
    }
}

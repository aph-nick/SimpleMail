package UI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        setTitle("SimpleMail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        topPanel.add(new JButton("b1"));
        topPanel.add(new JButton("b2"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        panel.add(topPanel, gbc);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new JButton("b3"));
        leftPanel.add(new JButton("b4"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.9;
        panel.add(leftPanel, gbc);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        GridBagConstraints innerGBC = new GridBagConstraints();
        innerGBC.fill = GridBagConstraints.HORIZONTAL;

        JTextField textField1 = new JTextField("Adresat:");
        innerGBC.gridx = 0;
        innerGBC.gridy = 0;
        rightPanel.add(textField1, innerGBC);

        JTextField textField2 = new JTextField("Temat:");
        innerGBC.gridx = 0;
        innerGBC.gridy = 1;
        rightPanel.add(textField2, innerGBC);

        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        innerGBC.gridx = 0;
        innerGBC.gridy = 2;
        innerGBC.gridwidth = 2;
        innerGBC.fill = GridBagConstraints.BOTH;
        rightPanel.add(scrollPane, innerGBC);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        gbc.weighty = 0.9;
        panel.add(rightPanel, gbc);

        pack();
        setContentPane(panel);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
}

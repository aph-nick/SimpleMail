package UI;

import UI.Panels.LeftPanel.LeftPanel;
import UI.Panels.RightPanel;
import UI.Panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Mail App");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();

        leftPanel.setMailSelectionListener(rightPanel);

        add(new TopPanel(leftPanel), BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}


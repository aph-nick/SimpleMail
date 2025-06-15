package UI;

import UI.Panels.LeftPanel;
import UI.Panels.RightPanel;
import UI.Panels.TopPanel;
import UI.TextArea.MailContentArea;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Mail App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new TopPanel(), BorderLayout.NORTH);
        add(new LeftPanel(), BorderLayout.WEST);
        add(new RightPanel(), BorderLayout.EAST);

        setVisible(true);
    }
}


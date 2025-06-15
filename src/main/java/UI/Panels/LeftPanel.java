package UI.Panels;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel() {
        add(new JLabel("Sent Mails"));
        add(new JList());
        setPreferredSize(new Dimension(450, 600));


    }
}

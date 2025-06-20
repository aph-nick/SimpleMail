package UI.Panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel() {
        JLabel sentMails = new JLabel("Sent Mails");
        sentMails.setFont(new Font("Arial", Font.BOLD, 18));
        add(sentMails);
        add(new JList());
        setPreferredSize(new Dimension(300, 600));
        setBorder(new LineBorder(Color.DARK_GRAY));


    }
}

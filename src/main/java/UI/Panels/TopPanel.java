package UI.Panels;

import UI.Buttons.AddContactButton;
import UI.Buttons.SendMailButton;
import UI.Clock.ClockDisplay;
import UI.Panels.LeftPanel.LeftPanel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    public TopPanel(LeftPanel leftPanel) {
        setLayout(new BorderLayout());

        LineBorder lineBorder = new LineBorder(Color.DARK_GRAY, 1);
        EmptyBorder paddingBorder = new EmptyBorder(10, 0, 10, 15);
        CompoundBorder combinedBorder = new CompoundBorder(lineBorder, paddingBorder);

        setBorder(combinedBorder);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(0, 15, 0));
        buttons.add(new SendMailButton(leftPanel));
        buttons.add(new AddContactButton());
        add(buttons, BorderLayout.WEST);

        JPanel blankPanel = new JPanel();
        add(blankPanel, BorderLayout.CENTER);
        add(new ClockDisplay(), BorderLayout.EAST);
    }
}

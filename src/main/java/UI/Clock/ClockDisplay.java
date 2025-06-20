package UI.Clock;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class ClockDisplay extends JLabel {
    LocalDateTime time = LocalDateTime.now();

    public ClockDisplay() {
        super("23:59:59");
        setSize(200,100);
        setFont(new Font("Arial", Font.BOLD, 30));
    }
}

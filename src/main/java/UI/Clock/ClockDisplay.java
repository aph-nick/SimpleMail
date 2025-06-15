package UI.Clock;

import javax.swing.*;
import java.time.LocalDateTime;

public class ClockDisplay extends JLabel {
    LocalDateTime time = LocalDateTime.now();

    public ClockDisplay() {
        super("Clock");
    }
}

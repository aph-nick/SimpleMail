package UI.Buttons;

import javax.swing.*;
import java.awt.*;

public class CancelButton extends JButton {
    public CancelButton() {
        super("Cancel");
        setBackground(Color.red);
        setBorder(new RoundedBorder(20));
    }
}

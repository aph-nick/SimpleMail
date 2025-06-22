package UI.TextArea;

import javax.swing.*;
import java.awt.*;

public class MailContentArea extends JTextArea {
    public MailContentArea() {
        setFont(new Font("Arial", Font.PLAIN,  20));
        setEditable(true);
    }

    public void setEditable(boolean editable) {
        super.setEditable(editable);
    }

    public void setText(String text) {
        super.setText(text);
    }
}

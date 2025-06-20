package UI.TextFields;

import javax.swing.*;
import java.awt.*;

public class GeneralTextField extends JPanel {
    protected JLabel label;
    protected JTextField field;

    public GeneralTextField(String labelText) {
        this.label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(100, 40));
        this.label.setFont(new Font("Arial", Font.BOLD, 18));
        this.field = new JTextField(20);
        this.field.setEditable(true);
        this.field.setFont(new Font("Arial", Font.PLAIN,  18));

        setLayout(new BorderLayout(5,0));
        add(label, BorderLayout.WEST);
        add(field, BorderLayout.CENTER);


        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getField() {
        return field;
    }
}

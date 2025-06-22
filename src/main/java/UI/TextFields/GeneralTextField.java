package UI.TextFields;

import javax.swing.*;
import java.awt.*;

public class GeneralTextField extends JPanel {
    protected JLabel label;
    protected JTextField field;

    public GeneralTextField(String labelText) {
        this.label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(120, 40));
        this.label.setFont(new Font("Arial", Font.BOLD, 20));
        this.field = new JTextField(20);
        this.field.setFont(new Font("Arial", Font.PLAIN,  20));
        this.field.setEditable(true);

        setLayout(new BorderLayout(7,0));
        add(label, BorderLayout.WEST);
        add(field, BorderLayout.CENTER);


        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
    }

    public void setFieldBackground(Color color) {
        field.setBackground(color);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getField() {
        return field;
    }
    public void setEditable(boolean editable) {
        field.setEditable(editable);
    }

    public void setText(String text) {
        field.setText(text);
    }
}

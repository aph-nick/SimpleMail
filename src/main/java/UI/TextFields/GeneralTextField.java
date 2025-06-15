package UI.TextFields;

import javax.swing.*;

public class GeneralTextField {
    protected JLabel label;
    protected JTextField field;

    public GeneralTextField(String labelText) {
        this.label = new JLabel(labelText);
        this.field = new JTextField( 20);
        this.field.setEditable(true);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getField() {
        return field;
    }
}

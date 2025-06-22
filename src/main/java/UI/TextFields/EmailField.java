package UI.TextFields;

import MailData.EmailCheck;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class EmailField extends GeneralTextField {

    public EmailField() {
        super("Email: ");

        JTextField emailInputField = getField();

        emailInputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkEmailValidity();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkEmailValidity();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            private void checkEmailValidity() {
                String email = emailInputField.getText();

                if (email.isEmpty()) {
                    setFieldBackground(Color.WHITE);
                } else if (EmailCheck.checkEmail(email)) {
                    setFieldBackground(new Color(200, 255, 200));
                } else {
                    setFieldBackground(new Color(255, 200, 200));
                }
            }
        });
    }
}
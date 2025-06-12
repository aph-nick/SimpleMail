import MailData.User;
import UI.MainFrame;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.awt.*;
import javax.swing.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*User user = new User("example@email.com", "test");

        Email email = EmailBuilder
                .startingBlank()
                .from("email@email.com")
                .to("example@example.com")
                .withSubject("Subject")
                .withPlainText("Plain text")
                .buildEmail();

        try (Mailer mailer = MailerBuilder.withSMTPServer("smtp.gmail.com", 587, user.getEmail(), user.getPassword())
                .buildMailer()) {
            mailer.sendMail(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } */

        SwingUtilities.invokeLater(() -> {
        new MainFrame();

        });
    }
}

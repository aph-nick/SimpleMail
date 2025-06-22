package MailData;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class EmailSender {

    private static final String SENDER_EMAIL = "twoj_email@gmail.com";
    private static final String SENDER_PASSWORD = "twoje_haslo_do_aplikacji";

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;

    public static void sendRealEmail(Message message) {
        String receiverEmail = message.getReceiver();
        String topic = message.getTopic();
        String content = message.getContent();

        if (receiverEmail == null || receiverEmail.trim().isEmpty() ||
                topic == null || topic.trim().isEmpty() ||
                content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Cannot send email: Receiver, topic, or content is empty.");
        }
        if (!EmailCheck.checkEmail(receiverEmail)) {
            throw new IllegalArgumentException("Cannot send email: Invalid receiver email format: " + receiverEmail);
        }

        Email email = EmailBuilder.startingBlank()
                .from(SENDER_EMAIL)
                .to(receiverEmail)
                .withSubject(topic)
                .withPlainText(content)
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer(SMTP_HOST, SMTP_PORT, SENDER_EMAIL, SENDER_PASSWORD)
                .buildMailer()) {
            mailer.sendMail(email);
            System.out.println("E-mail wysłany pomyślnie do: " + receiverEmail);
        } catch (Exception e) {
            System.err.println("Wystąpił błąd podczas wysyłania e-maila: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
        }
    }
}
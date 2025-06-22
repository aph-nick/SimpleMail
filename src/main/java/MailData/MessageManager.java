package MailData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageManager {
    private static final String SENT_EMAILS_FILE = "sent_emails.txt";
    private static List<Message> sentMails = new ArrayList<>();

    static {
        loadSentMails();
    }

    private static void loadSentMails() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SENT_EMAILS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Message message = Message.fromFileString(line);
                if (message != null) {
                    sentMails.add(message);
                }
            }
        } catch (IOException e) {

        }
    }

    public static List<Message> getSentMails() {
        return new ArrayList<>(sentMails);
    }

    public static void addSentMail(Message message) {
        sentMails.add(message);
        saveSentMailToFile(message);
    }

    private static void saveSentMailToFile(Message message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SENT_EMAILS_FILE, true))) {
            writer.write(message.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
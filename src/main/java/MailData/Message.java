package MailData;

public class Message {
    private String receiver;
    private Contact contact;
    private String subject;
    private String content;

    public Message(String receiver, String subject, String content) {
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
    }

    public Message(Contact contact, String subject, String content) {
        this.contact = contact;
        this.subject = subject;
        this.content = content;
    }
}

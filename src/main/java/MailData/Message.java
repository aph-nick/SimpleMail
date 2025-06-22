package MailData;

public class Message {
    private String receiver;
    private Contact contact;
    private String topic;
    private String content;

    public Message(String receiver, String subject, String content) {
        this.receiver = receiver;
        this.topic = subject;
        this.content = content;
    }

    public Message(Contact contact, String subject, String content) {
        this.contact = contact;
        this.topic = subject;
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return topic;
    }

    public String toFileString() {
        String actualReceiver = (contact != null) ? contact.getEmail() : receiver;
        return topic + ":::" + actualReceiver + ":::" + content.replace("\n", "\\n");
    }

    public static Message fromFileString(String line) {
        String[] parts = line.split(":::", 3);
        if (parts.length == 3) {
            return new Message(parts[1], parts[0], parts[2].replace("\\n", "\n"));
        }
        return null;
    }
}


package MailData;

public class User {
    private String email;
    private String password;


    public User(String email, String password) {
        if(EmailCheck.checkEmail(email)) {
           this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        if(EmailCheck.checkEmail(email)) {
            this.email = email;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Email: " + email + " Password: " + password;
    }
}

# 📬 SimpleMail – Java Mail App with Swing & SimpleJavaMail

SimpleMail to prosta aplikacja desktopowa napisana Javie, która umożliwia wysyłanie e-maili bezpośrednio z poziomu interfejsu graficznego. Powstał jako szkolny projekt programistyczny, a jego celem było połączenie możliwości biblioteki `SimpleJavaMail` z prostym interfejsem graficznym zbudowanym przy użyciu biblioteki `Swing`.

## 🧩 Funkcje aplikacji

- ✉️ Wysyłanie wiadomości e-mail z własnego konta
- 👤 Dodawanie kontaktów oraz wybór z listy przy wysyłaniu
- 🕒 Wbudowany zegar w interfejsie
- 📜 Historia wysłanych wiadomości
- 🧾 Możliwość wysyłania wiadomości także bez wyboru kontaktu

## 🖥️ Interfejs użytkownika

Aplikacja posiada przejrzysty, minimalistyczny interfejs użytkownika.

![image](https://github.com/user-attachments/assets/3c88c453-1549-4c40-b45d-0e73a369c3dc)

---

## 📦 Wykorzystane technologie

- **Java**
- **Swing** – GUI
- **[SimpleJavaMail](https://www.simplejavamail.org/)** – biblioteka do obsługi SMTP/SSL i wysyłania maili

---

## 🔐 Konfiguracja danych logowania

W celu umożliwienia aplikacji wysyłania maili z Twojego adresu, wymagane jest podanie danych logowania do konta e-mail. Dane te należy wpisać w klasie `EmailSender.java`.

```java
public class EmailSender {
    private static final String USERNAME = "your_email@example.com";
    private static final String PASSWORD = "your_email_password";

    // ...
}
```

⚠️ **UWAGA:** Nie commituj pliku `EmailSender.java` z prawdziwymi danymi logowania do repozytorium publicznego!


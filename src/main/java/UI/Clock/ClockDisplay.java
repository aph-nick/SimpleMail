package UI.Clock;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockDisplay extends JLabel {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ClockDisplay() {
        super(LocalDateTime.now().format(FORMATTER));
        setSize(200, 100);
        setFont(new Font("Arial", Font.BOLD, 30));
        setHorizontalAlignment(SwingConstants.CENTER);

        startClockUpdateThread();
    }

    private void startClockUpdateThread() {
        Thread clockThread = new Thread(() -> {
            while (true) {
                LocalDateTime now = LocalDateTime.now();
                String formattedTime = now.format(FORMATTER);

                SwingUtilities.invokeLater(() -> {
                    setText(formattedTime);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        clockThread.setDaemon(true);
        clockThread.start();
    }
}
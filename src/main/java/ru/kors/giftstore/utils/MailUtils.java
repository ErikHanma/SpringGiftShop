package ru.kors.giftstore.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class MailUtils {
    private MailUtils() {

    }

    public static SimpleMailMessage createMailMessage(final String mail,
                                                      final String mailFrome,
                                                      final String subject,
                                                      final String text)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setFrom(mailFrome);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        return mailMessage;
    }


    public static SimpleMailMessage createMailMessage(final List<String> emails,
                                                      final String subject,
                                                      final String text) {
        return createMailMessage(
                emails.toArray(String[]::new),
                subject,
                text
        );
    }

    public static SimpleMailMessage createMailMessage(final String[] emails,
                                                      final String subject,
                                                      final String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("aptproject@mail.ru");
        mailMessage.setTo(emails);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        return mailMessage;
    }
}


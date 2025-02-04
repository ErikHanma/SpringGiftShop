package ru.kors.giftstore.constants;

public interface MailConstants {

    String MAIL_MESSAGE_FOR_REMEMBER_PASSWORD = """
            
            Добрый день. Вы получили письмо, так как с вашего аккаунта поступила заявка
            на восстановление пароля. Пожалуйста, перейдтие
            по ссылке: http://localhost:8080/users/change-password?uuid=""";

    String MAIL_SUBJECT_FOR_REMEMBER_PASSWORD = "Восстановление пароля на сайте библиотеки";
}

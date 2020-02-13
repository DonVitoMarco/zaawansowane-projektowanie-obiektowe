package pl.marek.todoist.domain.mail.sender;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import pl.marek.todoist.domain.mail.Mail;

import static java.text.MessageFormat.format;

@Service
@Log4j2
@Profile("email")
class SenderImpl implements Sender {

    private String subject;

    private String from;

    private JavaMailSender javaMailSender;

    public SenderImpl(JavaMailSender javaMailSender,
                      @Value("${mail.subject}") String subject,
                      @Value("${mail.from}") String from) {
        this.javaMailSender = javaMailSender;
        this.subject = subject;
        this.from = from;
    }

    @Retryable(
            value = {MailException.class},
            maxAttempts = 4,
            backoff = @Backoff(delay = 400)
    )
    @Override
    public void send(Mail mail, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getTo());
        message.setText(body);
        message.setSubject(subject);
        message.setFrom(from);

        log.info(format("Start sending mail with id : {0}", mail.getId()));
        javaMailSender.send(message);
    }
}

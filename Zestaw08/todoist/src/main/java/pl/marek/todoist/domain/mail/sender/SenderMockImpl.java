package pl.marek.todoist.domain.mail.sender;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.marek.todoist.domain.mail.Mail;

import static java.text.MessageFormat.format;

@Service
@Log4j2
@Profile("!email")
class SenderMockImpl implements Sender {

    @Override
    public void send(Mail mail, String body) {
        log.info("Use MOCK sender implementation");

        log.info(format("Start sending mail with id : {0}", mail.getId()));
        log.info(format("Mail : {0}", body));
    }
}

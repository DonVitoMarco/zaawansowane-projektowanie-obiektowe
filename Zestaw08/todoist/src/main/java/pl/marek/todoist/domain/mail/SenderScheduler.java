package pl.marek.todoist.domain.mail;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.marek.todoist.domain.mail.sender.Sender;
import pl.marek.todoist.domain.mail.template.TemplateParser;

import java.time.Instant;

import static java.text.MessageFormat.format;

@Service
@Log4j2
@AllArgsConstructor
public class SenderScheduler {

    private MailService service;

    private Sender sender;

    private TemplateParser parser;

    @Scheduled(cron = "${mailsender.mail.cron}")
    public void fetch() {
        log.info(format("Start scheduled action : fetching pending email : {0}", Instant.now()));

        service.getPendingMessageAndUpdateToProcessingStatus()
                .ifPresent(this::sendMailAndUpdateStatus);

        log.debug("End scheduled action : fetching pending mails");
    }

    private void sendMailAndUpdateStatus(Mail mail) {
        Option<String> body = parser.parse(mail.getTemplateName(), mail.getParams());

        try {
            sender.send(mail, body.get());
            mail.setSentStatus();
        } catch (Exception e) {
            log.error(format("Cannot send mail with id : {0} : {1}", mail.getId(), e.getMessage()));
            mail.setErrorStatus();
        }

        service.updateStatus(mail.getId(), mail.getStatus());
    }
}

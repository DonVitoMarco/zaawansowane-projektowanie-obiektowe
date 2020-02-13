package pl.marek.todoist.domain.mail;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.marek.todoist.domain.events.MailSendEvent;

import static java.text.MessageFormat.format;

@Component
@Log4j2
@AllArgsConstructor
class MailSenderEventListener {

    private MailService service;

    @Async
    @EventListener
    public void handleMailEvent(MailSendEvent mailSendEvent) {
        log.info(format("Handle MailSendEvent : {0}", mailSendEvent.toString()));
        service.createPendingMail(createPendingMail(mailSendEvent));
    }

    private Mail createPendingMail(MailSendEvent mailSendEvent) {
        return Mail.builder()
                .to(mailSendEvent.getTo())
                .params(mailSendEvent.getParams())
                .templateName(mailSendEvent.getTemplateName())
                .build();
    }
}

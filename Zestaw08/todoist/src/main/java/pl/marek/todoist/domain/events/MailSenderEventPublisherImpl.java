package pl.marek.todoist.domain.events;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import static java.text.MessageFormat.format;

@Service
@Log4j2
@AllArgsConstructor
class MailSenderEventPublisherImpl implements MailSenderEventPublisher {

    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(MailSendEvent mailSendEvent) {
        log.info(format("Publish MailSendEvent : {0}", mailSendEvent.toString()));
        applicationEventPublisher.publishEvent(mailSendEvent);
    }
}

package pl.marek.todoist.domain.events;

public interface MailSenderEventPublisher {

    void publish(MailSendEvent mailSendEvent);
}

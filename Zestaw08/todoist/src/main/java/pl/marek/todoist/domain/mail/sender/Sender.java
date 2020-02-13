package pl.marek.todoist.domain.mail.sender;

import pl.marek.todoist.domain.mail.Mail;

public interface Sender {

    void send(Mail mail, String body);
}

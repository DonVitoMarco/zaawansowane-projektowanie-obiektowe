package pl.marek.todoist.domain.events;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@ToString
public class MailSendEvent {

    private String to;

    private String templateName;

    private Map<String, String> params;
}

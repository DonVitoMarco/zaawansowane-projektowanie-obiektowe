package pl.marek.todoist.domain.mail.template;

import io.vavr.control.Option;

import java.util.Map;

public interface TemplateParser {

    Option<String> parse(String templateName, Map<String, String> params);
}

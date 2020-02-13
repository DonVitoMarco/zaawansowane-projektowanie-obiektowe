package pl.marek.todoist.domain.mail.template;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.NumberTool;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.text.MessageFormat.format;

@Service
@Log4j2
@AllArgsConstructor
class VelocityParser implements TemplateParser {

    private static final String TEMPLATE_FOLDER = "templates/";

    private VelocityEngine velocityEngine;

    @Override
    public Option<String> parse(String templateName, Map<String, String> params) {
        Try<String> parse = Try
                .of(() -> parseTemplate(templateName, createContext(params)))
                .onFailure(t -> log.error(format("Error parsing template : {0}", templateName)));

        return parse.toOption();
    }

    private VelocityContext createContext(Map<String, String> params) {
        VelocityContext context = new VelocityContext();
        context.put("params", params);
        context.put("dataTool", new DateTool());
        context.put("dateFormatter", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        context.put("numberTool", new NumberTool());
        return context;
    }

    private String parseTemplate(String templateName, VelocityContext context) {
        StringWriter out = new StringWriter();

        Template template = velocityEngine.getTemplate(TEMPLATE_FOLDER + templateName);
        template.merge(context, out);

        return out.toString();
    }
}

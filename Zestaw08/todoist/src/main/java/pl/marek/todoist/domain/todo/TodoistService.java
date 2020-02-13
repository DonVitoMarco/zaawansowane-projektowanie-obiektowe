package pl.marek.todoist.domain.todo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.marek.todoist.domain.events.MailSendEvent;
import pl.marek.todoist.domain.events.MailSenderEventPublisher;
import pl.marek.todoist.domain.exception.ResourceNotFoundException;
import pl.marek.todoist.domain.mail.template.Template;

import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;
import static pl.marek.todoist.domain.todo.Todo.Status;

@Service
@Log4j2
@AllArgsConstructor
class TodoistService {

    private TodoRepository repository;
    private MailSenderEventPublisher publisher;

    Page<TodoView> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(TodoView.class::cast);
    }

    void create(CreateTodoRequest request) {
        log.debug(format("Creating new todo : {0}", request.toString()));
        Todo todo = Todo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .content(request.getContent())
                .status(Status.PENDING)
                .build();
        repository.save(todo);
        publisher.publish(createSendMailEvent(todo, Template.NEW));
    }

    void done(String todoId) {
        Todo todo = changeStatus(todoId, Status.DONE);
        publisher.publish(createSendMailEvent(todo, Template.DONE));
    }

    void undone(String todoId) {
        Todo todo = changeStatus(todoId, Status.UNDONE);
        publisher.publish(createSendMailEvent(todo, Template.UNDONE));
    }

    private Todo changeStatus(String todoId, Status newStatus) {
        log.debug(format("Changing status : {0} : {1}", todoId, newStatus));
        Todo todo = repository.findById(todoId).orElseThrow(() ->
                new ResourceNotFoundException(format("Cannot found todo with id : {0}", todoId)));

        repository.updateMailStatusTo(todo.getId(), newStatus);
        return todo;
    }

    private MailSendEvent createSendMailEvent(Todo todo, Template template) {
        Map<String, String> params = new HashMap<>();
        params.put("firstName", todo.getFirstName());
        params.put("lastName", todo.getLastName());
        params.put("id", todo.getId());

        return MailSendEvent.builder()
                .to(todo.getEmail())
                .templateName(template.getPath())
                .params(params)
                .build();
    }
}

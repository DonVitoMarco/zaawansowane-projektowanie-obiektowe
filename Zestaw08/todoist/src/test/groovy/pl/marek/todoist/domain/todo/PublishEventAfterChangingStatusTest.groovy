package pl.marek.todoist.domain.todo

import pl.marek.todoist.domain.events.MailSenderEventPublisher
import pl.marek.todoist.domain.exception.ResourceNotFoundException
import pl.marek.todoist.domain.todo.Todo
import pl.marek.todoist.domain.todo.TodoRepository
import pl.marek.todoist.domain.todo.TodoistService
import spock.lang.Specification

class PublishEventAfterChangingStatusTest extends Specification {

    private TodoRepository repository = Mock()

    private MailSenderEventPublisher publisher = Mock()

    private TodoistService service = new TodoistService(repository, publisher)

    def "todo exists should publish event"() {
        given:
        def id = UUID.randomUUID().toString()
        repository.findById(id) >> Optional.of(Todo.builder().id(id).build())
        repository.updateMailStatusTo(_, _) >> { true }

        when:
        service.done(id)

        then:
        1 * publisher.publish(_)
    }

    def "todo not exists should not publish event"() {
        given:
        def id = UUID.randomUUID().toString()
        repository.findById(id) >> Optional.empty()
        repository.updateMailStatusTo(_, _) >> { true }

        when:
        service.done(id)

        then:
        thrown ResourceNotFoundException
        0 * publisher.publish(_)
    }
}

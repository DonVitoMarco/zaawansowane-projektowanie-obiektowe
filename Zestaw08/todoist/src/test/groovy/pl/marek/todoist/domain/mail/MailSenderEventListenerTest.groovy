package pl.marek.todoist.domain.mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MailSenderEventListenerTest extends Specification {

    @Autowired
    private MailSenderEventListener listener

    @Autowired
    private MailRepository repository

    def setup() {
        repository.deleteAll()
    }

    def "should save pending message after handle event"() {
        given:
        def mailSendEvent = MailMotherObject.aMailSendEvent()

        when:
        listener.handleMailEvent(mailSendEvent)

        then:
        repository.findAll().size() == 1
    }
}

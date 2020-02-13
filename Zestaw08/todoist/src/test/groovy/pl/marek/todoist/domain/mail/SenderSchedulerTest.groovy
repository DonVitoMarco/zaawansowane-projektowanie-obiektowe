package pl.marek.todoist.domain.mail

import com.icegreen.greenmail.junit.GreenMailRule
import com.icegreen.greenmail.util.ServerSetup
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(profiles = "email")
class SenderSchedulerTest extends Specification {

    @Rule
    private GreenMailRule server = new GreenMailRule(new ServerSetup(3025, "localhost", "smtp"))

    @Autowired
    private SenderScheduler scheduler

    @Autowired
    private MailRepository repository

    def "should send mail and change status to sent"() {
        given:
        repository.save(MailMotherObject.aMail(UUID.randomUUID().toString(), MailStatus.PENDING))

        when:
        scheduler.fetch()

        then:
        repository.findAll().forEach({ m -> m.getStatus() == MailStatus.SENT })
        server.getReceivedMessages().size() == 1
    }

    def "wrong template name should not send email"() {
        given:
        def mail = Mail.builder()
                .id(UUID.randomUUID().toString())
                .to("mail@mail.pl")
                .templateName("doNotExists.vm")
                .status(MailStatus.PENDING)
                .build()
        repository.save(mail)

        when:
        scheduler.fetch()

        then:
        repository.findAll().forEach({ m -> m.getStatus() == MailStatus.ERROR })
        server.getReceivedMessages().size() == 0
    }
}

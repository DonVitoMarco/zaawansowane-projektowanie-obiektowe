package pl.marek.todoist

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.context.WebApplicationContext
import pl.marek.todoist.app.TodoistApplication
import spock.lang.Specification

@SpringBootTest
class ApplicationTest extends Specification {

    @Autowired
    private WebApplicationContext context

    def "should boot up without errors"() {
        expect: "web application context exists"
        context != null
    }

    def "should run main method without errors"() {
        TodoistApplication.main("--spring.main.web-environment=false")
    }
}

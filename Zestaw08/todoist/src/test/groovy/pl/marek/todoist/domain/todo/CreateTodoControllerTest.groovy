package pl.marek.todoist.domain.todo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import pl.marek.todoist.domain.todo.CreateTodoRequest
import pl.marek.todoist.domain.todo.TodoController
import pl.marek.todoist.domain.todo.TodoRepository
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TodoController)
class CreateTodoControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private TodoRepository repository

    private ObjectWriter objectWriter

    def setup() {
        repository.deleteAll()

        ObjectMapper mapper = new ObjectMapper()
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        objectWriter = mapper.writer().withDefaultPrettyPrinter()
    }

    def "should create todo"() {
        given:
        def createTodoRequest =
                new CreateTodoRequest("Bruce", "Wayne", "test@testowy.pl", "content")
        def request = objectWriter.writeValueAsString(createTodoRequest)

        when:
        def result = mockMvc.perform(post("/todoist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))

        then:
        result.andExpect(status().isCreated())
        repository.findAll().size() == 1
    }

    def "wrong email address should return bad request status"() {
        given:
        def createTodoRequest =
                new CreateTodoRequest("Norman", "Jayden", "test.test", "content")
        def request = objectWriter.writeValueAsString(createTodoRequest)

        when:
        def result = mockMvc.perform(post("/todoist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))

        then:
        result.andExpect(status().isBadRequest())
        repository.findAll().size() == 0
    }

    def "empty first name should return bad request status"() {
        given:
        def createTodoRequest =
                new CreateTodoRequest("", "Jayden", "test.test", "content")
        def request = objectWriter.writeValueAsString(createTodoRequest)

        when:
        def result = mockMvc.perform(post("/todoist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))

        then:
        result.andExpect(status().isBadRequest())
        repository.findAll().size() == 0
    }
}

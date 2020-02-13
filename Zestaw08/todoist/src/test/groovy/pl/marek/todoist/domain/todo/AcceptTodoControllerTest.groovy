package pl.marek.todoist.domain.todo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TodoController)
class AcceptTodoControllerTest extends Specification {

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

    def "should change status todo to done"() {
        given:
        def todo = TodoMotherObject.aTodo()
        repository.save(todo)

        when:
        def result = mockMvc.perform(patch("/todoist/" + todo.getId()))

        then:
        result.andExpect(status().isNoContent())

        def todos = repository.findAll()
        todos.size() == 1
        todos.findAll().get(0).getStatus() == Todo.Status.DONE
    }

    def "todo not exists should return not found exception"() {
        given:
        def todo = TodoMotherObject.aTodo()
        repository.save(todo)

        when:
        def result = mockMvc.perform(patch("/todoist/" + UUID.randomUUID().toString()))

        then:
        result.andExpect(status().isNotFound())
        repository.findAll().size() == 1
    }
}

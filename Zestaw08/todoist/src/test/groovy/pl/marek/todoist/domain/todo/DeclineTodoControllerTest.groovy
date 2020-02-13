package pl.marek.todoist.domain.todo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TodoController)
class DeclineTodoControllerTest extends Specification {

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

    def "should change status todo to undone"() {
        given:
        def todo = TodoMotherObject.aTodo()
        repository.save(todo)

        when:
        def result = mockMvc.perform(delete("/todoist/" + todo.getId()))

        then:
        result.andExpect(status().isNoContent())

        def todos = repository.findAll()
        todos.size() == 1
        todos.findAll().get(0).getStatus() == Todo.Status.UNDONE
    }

    def "todo not exists should return not found status"() {
        given:
        def todo = TodoMotherObject.aTodo()
        repository.save(todo)

        when:
        def result = mockMvc.perform(delete("/todoist/" + UUID.randomUUID().toString()))

        then:
        result.andExpect(status().isNotFound())
        repository.findAll().size() == 1
    }
}

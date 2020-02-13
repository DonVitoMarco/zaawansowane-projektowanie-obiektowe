package pl.marek.todoist.domain.todo


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TodoController)
class GetTodoControllerTest extends Specification {

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

    def "should return page with todo"() {
        given:
        12.times { repository.save(TodoMotherObject.aTodo(UUID.randomUUID().toString())) }

        when:
        def result = mockMvc.perform(get("/todoist"))

        then:
        result.andExpect(status().isOk())
    }
}

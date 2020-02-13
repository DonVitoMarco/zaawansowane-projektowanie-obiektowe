package pl.marek.todoist.domain.todo;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static pl.marek.todoist.domain.todo.Todo.Status;

@AllArgsConstructor
class CustomTodoRepositoryImpl implements CustomTodoRepository {

    private static final String STATUS_FIELD = "status";
    private static final String ID_FIELD = "id";

    private MongoTemplate mongoTemplate;

    public void updateMailStatusTo(String id, Status status) {
        Query query = new Query();
        query.addCriteria(Criteria.where(ID_FIELD).is(id));

        Update update = new Update();
        update.set(STATUS_FIELD, status);

        mongoTemplate.findAndModify(query, update, Todo.class);
    }
}

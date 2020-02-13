package pl.marek.todoist.domain.todo;

import org.springframework.data.mongodb.repository.MongoRepository;

interface TodoRepository extends MongoRepository<Todo, String>, CustomTodoRepository {
}

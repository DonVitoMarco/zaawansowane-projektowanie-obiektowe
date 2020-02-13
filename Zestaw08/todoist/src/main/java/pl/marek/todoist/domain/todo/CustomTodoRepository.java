package pl.marek.todoist.domain.todo;

import static pl.marek.todoist.domain.todo.Todo.Status;

interface CustomTodoRepository {

    void updateMailStatusTo(String id, Status status);
}

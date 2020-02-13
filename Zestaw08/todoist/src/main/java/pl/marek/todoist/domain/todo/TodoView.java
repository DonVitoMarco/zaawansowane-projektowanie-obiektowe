package pl.marek.todoist.domain.todo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pl.marek.todoist.domain.todo.Todo.Status;

@JsonSerialize(as = TodoView.class)
interface TodoView {

    String getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getContent();

    Status getStatus();
}

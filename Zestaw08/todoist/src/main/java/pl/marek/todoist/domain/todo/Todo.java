package pl.marek.todoist.domain.todo;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Builder
@Document(collection = "todos")
class Todo implements TodoView {

    public enum Status {
        PENDING, DONE, UNDONE
    }

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Status status;

    private String content;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;
}

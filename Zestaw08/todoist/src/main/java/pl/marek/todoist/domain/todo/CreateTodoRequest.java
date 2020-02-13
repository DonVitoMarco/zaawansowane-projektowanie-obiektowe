package pl.marek.todoist.domain.todo;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
@Builder
@ToString
class CreateTodoRequest {

    @NotNull(message = "First name value must not be empty!")
    @Size(min = 3, max = 20, message = "First name must be between 3 - 20 signs!")
    private String firstName;

    @NotNull(message = "Last name value must not be empty!")
    @Size(min = 3, max = 20, message = "Last name must be between 3 - 20 signs!")
    private String lastName;

    @NotNull(message = "Email value must not be empty!")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Content must not be empty!")
    @Size(min = 3, max = 200, message = "Content should be valid")
    private String content;
}

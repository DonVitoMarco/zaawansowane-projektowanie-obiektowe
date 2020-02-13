package pl.marek.todoist.domain.todo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todoist")
@Api(tags = "Todoist")
@AllArgsConstructor
class TodoController {

    private TodoistService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get pageable Todos")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Page<TodoView>> getPage(@PageableDefault @SortDefault.SortDefaults(
            @SortDefault(sort = "email", direction = Sort.Direction.DESC)) Pageable pageable) {

        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create Todo")
    @CrossOrigin(origins = "*")
    public void createTodo(@RequestBody @Valid CreateTodoRequest request) {

        service.create(request);
    }

    @PatchMapping(value = "/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Accept Todo")
    @CrossOrigin(origins = "*")
    public void doneTodo(@PathVariable String todoId) {

        service.done(todoId);
    }

    @DeleteMapping(value = "/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Decline Todo")
    @CrossOrigin(origins = "*")
    public void undoneTodo(@PathVariable String todoId) {

        service.undone(todoId);
    }
}

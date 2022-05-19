package com.example.api;

import com.example.api.payload.TodoInput;
import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.exceptions.TodoNotFoundException;
import com.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/api/v1/todos")
public class TodosRestController_v1 {

    static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "todo-1", true, TodoType.OFFICIAL));
        todos.add(new Todo(2, "todo-2", true, TodoType.OFFICIAL));
        todos.add(new Todo(3, "todo-3", false, TodoType.PERSONAL));
        todos.add(new Todo(4, "todo-4", true, TodoType.PERSONAL));
        todos.add(new Todo(5, "todo-5", false, TodoType.OFFICIAL));
        todos.add(new Todo(6, "todo-6", false, TodoType.PERSONAL));
    }

    @GetMapping(
            params = {"type"},
            headers = {"Accept-language"}
    )
    public ResponseEntity<?> getTodosByType(@RequestParam(value = "type") String type) {
        List<Todo> result = null;
        if (type.equals("official"))
            result = todos
                    .stream()
                    .filter(todo -> todo.getType() == TodoType.OFFICIAL)
                    .collect(Collectors.toList());
        else if (type.equals("personal"))
            result = todos
                    .stream()
                    .filter(todo -> todo.getType() == TodoType.PERSONAL)
                    .collect(Collectors.toList());
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok().body(result);
    }

    @PostConstruct
    public void init(){
        System.out.println("TodosRestController_v1:init()");
    }

    @GetMapping(
            params = {"!type"},
            headers = {"Accept-language", "My-Header"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> getTodos(
            @RequestHeader("Accept-language") String language,
            @RequestHeader(value = "My-Header", required = true) String myHeader
    ) {
        System.out.println(language);
        System.out.println(myHeader);
        return ResponseEntity.ok().body(todos);
    }


    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> getTodo(
            @PathVariable String id
    ) {
        Todo existingTodo = todos
                .stream()
                .filter(todo -> todo.getId() == Integer.parseInt(id))
                .findAny()
                .orElseThrow(() -> new TodoNotFoundException("todo not exist"));
        return ResponseEntity.ok(existingTodo);
    }


    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<?> createTodo(
//            @RequestParam(value="title") String title,
//            @RequestParam String type,
            //@ModelAttribute TodoInput todoInput
            @RequestBody TodoInput todoInput
    ) {
        Todo newTodo = new Todo();
        newTodo.setId(todos.size() + 1);
        newTodo.setTitle(todoInput.getTitle());
        newTodo.setType(TodoType.valueOf(todoInput.getType().toUpperCase()));
        todos.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }


    @PatchMapping(
            value = "/{id}",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> updateTodo(
            @PathVariable String id, @RequestBody TodoInput todoInput
    ) {
        Todo existingTodo = todos
                .stream()
                .filter(todo -> todo.getId() == Integer.parseInt(id))
                .findAny()
                .orElse(null);
        assert existingTodo != null;
        existingTodo.setTitle(todoInput.getTitle());
        existingTodo.setType(TodoType.valueOf(todoInput.getType().toUpperCase()));
        return ResponseEntity.ok(existingTodo);
    }


    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> deleteTodo(
            @PathVariable String id
    ) {
        todos = todos
                .stream()
                .filter(todo -> todo.getId() != Integer.parseInt(id))
                .collect(Collectors.toList());
        return ResponseEntity.ok().build();
    }


    @ExceptionHandler(
            value = {TodoNotFoundException.class}
    )
    public ResponseEntity<?> notFoundExceptionHandler(Throwable e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


}

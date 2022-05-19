package com.example.api;

import com.example.api.payload.TodoInput;
import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.exceptions.TodoNotFoundException;
import com.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/v2/todos")
public class TodosRestController_v2 {

    private TodoRepository todoRepository;

    public TodosRestController_v2(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getTodos() {
        Iterable<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok().body(todos);
    }


    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> getTodo(
            @PathVariable String id
    ) {
        Todo todo = todoRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new TodoNotFoundException("todo not exist"));
        return ResponseEntity.ok(todo);
    }


    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<?> createTodo(
            @RequestBody TodoInput todoInput
    ) {
        Todo newTodo = new Todo();
        newTodo.setTitle(todoInput.getTitle());
        Todo savedTodo = todoRepository.save(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }


    @PatchMapping(
            value = "/{id}",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> updateTodo(
            @PathVariable String id, @RequestBody TodoInput todoInput
    ) {
        Todo todo = todoRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new TodoNotFoundException("todo not exist"));
        todo.setTitle(todoInput.getTitle());
        Todo savedTodo = todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }


    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> deleteTodo(
            @PathVariable String id
    ) {
        todoRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }


    @ExceptionHandler(
            value = {TodoNotFoundException.class}
    )
    public ResponseEntity<?> notFoundExceptionHandler(Throwable e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


}

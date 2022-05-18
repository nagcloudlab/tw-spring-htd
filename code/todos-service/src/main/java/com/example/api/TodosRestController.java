package com.example.api;

import com.example.entity.Todo;
import com.example.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value="/api/todos")
public class TodosRestController {

    private TodoRepository todoRepository;

    public TodosRestController(TodoRepository repository) {
        this.todoRepository = repository;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getAll(){
        Iterable<Todo> todos=todoRepository.findAll();
        return ResponseEntity.ok().body(todos);
    }


}

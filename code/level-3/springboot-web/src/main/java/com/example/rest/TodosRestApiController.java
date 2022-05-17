package com.example.rest;

import com.example.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodosRestApiController {

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    public List<Todo>  getTodos(){
        return List.of(
                new Todo(1,"todo-1",true),
                new Todo(2,"todo-2",true)
        );
    }

}

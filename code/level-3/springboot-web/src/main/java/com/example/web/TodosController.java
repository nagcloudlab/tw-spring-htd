package com.example.web;

import com.example.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodosController {

    @RequestMapping(
            method = RequestMethod.GET
    )
    public ModelAndView getTodos(){
        List<Todo> todos=List.of(
                new Todo(1,"todo-1",true),
                new Todo(2,"todo-2",true)
        );
        ModelAndView mav=new ModelAndView();
        mav.addObject("todos",todos);
        mav.setViewName("todos-view");
        return mav;
    }

}

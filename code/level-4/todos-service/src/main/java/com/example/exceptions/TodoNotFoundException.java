package com.example.exceptions;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String todo_not_exist) {
        super(todo_not_exist);
    }
}

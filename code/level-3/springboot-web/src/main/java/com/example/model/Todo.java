package com.example.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Todo {

    private int id;
    private String title;
    private boolean completed;

}

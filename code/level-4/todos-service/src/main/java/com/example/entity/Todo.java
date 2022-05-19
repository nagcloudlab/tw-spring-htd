package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private boolean completed;
    @Transient
    private TodoType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(int id, String title, boolean completed,TodoType type) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.type=type;
    }
}

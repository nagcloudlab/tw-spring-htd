package com.example.repository;

import com.example.entity.Todo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodoRepository extends PagingAndSortingRepository<Todo,Integer> {
}

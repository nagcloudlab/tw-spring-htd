package com.example.repository;

import com.example.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

    Optional<User> findByNameLike(String name);

}

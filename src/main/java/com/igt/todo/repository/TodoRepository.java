package com.igt.todo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.igt.todo.model.Todo;

@RepositoryRestResource(path = "app", collectionResourceRel = "app")
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByName(String name);
    List<Todo> findByDescription(String description);
    
}

package com.igt.todo.service;

import java.util.List;

import com.igt.todo.model.Todo;

public interface TodoService {

    Todo createTodo(Todo todo);

    Todo findTodo(Long id);
    
    List<Todo> findTodo(String name);
    
    List<Todo> findTodoByDescription(String key);

    void deleteTodo(Long id);

    List<Todo> getAll();

}
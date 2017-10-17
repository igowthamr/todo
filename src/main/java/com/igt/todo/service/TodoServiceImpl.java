package com.igt.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igt.todo.model.Todo;
import com.igt.todo.repository.TodoRepository;


@Service
public class TodoServiceImpl implements TodoService {
	
	@Resource
	private TodoRepository repo;

	@Override
	public Todo createTodo(Todo todo) {
		todo.setAddedDate(new Date(System.currentTimeMillis()));
		Todo tod = repo.save(todo);
		return tod;
	}



	@Override
	public void deleteTodo(Long id) {
		repo.delete(id);
	}

	@Override
	public List<Todo> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	@Override
	public Todo findTodo(Long id) {
		Todo todo = repo.findOne(id);
		return todo;
	}



	@Override
	public List<Todo> findTodo(String name) {
		List<Todo> list = repo.findByName(name);
		return list;
	}



	@Override
	public List<Todo> findTodoByDescription(String key) {
		List<Todo> all = repo.findAll();
		List<Todo> newList = new ArrayList<>();
		for(Todo todo:all){
			if(todo.getDescription().contains(key)){
				newList.add(todo);
			}
		}
		return newList;
	}

}
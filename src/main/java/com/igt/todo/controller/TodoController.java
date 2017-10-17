package com.igt.todo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.igt.todo.model.Todo;
import com.igt.todo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Resource
	private TodoService service;
	
	@RequestMapping( value="/all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Todo> getAllTodos(){
		return service.getAll();
	}
	
	@RequestMapping( value="/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTodo(@PathVariable Long id){
		service.deleteTodo(id);
	}
	
	@RequestMapping( method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Todo createTodo(@RequestBody Todo todo){
		return service.createTodo(todo);
	}
	
	@RequestMapping( value="/search", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Todo> getTodoByNameOfTodo(@RequestParam String name){
		return service.findTodo(name);
	}
	
	@RequestMapping(value="/searchByKey",  method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Todo> getTodoByDescription(@RequestParam String descriptionKey){
		return service.findTodoByDescription(descriptionKey);
	}
	
	
}

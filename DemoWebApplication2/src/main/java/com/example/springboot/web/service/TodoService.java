package com.example.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springboot.web.model.Todo;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "suyog123", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "suyog", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "suyog", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = todos.stream().filter(todos->todos.getUser().equalsIgnoreCase(user)).collect(Collectors.toList());        
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {       
    	todos.stream().filter(todos->todos.getId()==id).findFirst().map(r->todos.remove(r));
    }
    
    public Todo getSingleTodo(int id) {       
    	Optional<Todo> todo = todos.stream().filter(todos->todos.getId()==id).findFirst();
    	return todo.get();
    }
    
    public void updateTodo(Todo todo) {
    	todos.remove(todo);
    	todos.add(todo);
    }


}

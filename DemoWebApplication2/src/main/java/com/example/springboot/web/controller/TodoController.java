package com.example.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.springboot.web.model.Todo;
import com.example.springboot.web.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {		
	SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
	@RequestMapping(value="/todoList", method=RequestMethod.GET)
	public String getToDOList(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", service.retrieveTodos(name));
		return "todoList";
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String)model.get("name");
	}
	
	@RequestMapping(value="/addTodo",method=RequestMethod.GET)
	public String getAddTODOPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "", new Date(), false));
		return "addTodo";
	}
	@RequestMapping(value="/addTodo", method=RequestMethod.POST)
	public String addToDO(ModelMap model, @Valid Todo todo, BindingResult result) {		
		if(result.hasErrors()) {
			return "addTodo";
		}
		service.addTodo(getLoggedInUserName(model), todo.getDesc(), new Date(), false);
		return "redirect:/todoList";
	}
	
	@RequestMapping(value="/updateTODO",method=RequestMethod.GET)
	public String showUpdateTODO(@RequestParam int id, ModelMap model) {
		Todo todo = service.getSingleTodo(id);
		model.put("todo", todo);
		
		return "addTodo";
	}
	@RequestMapping(value="/updateTODO", method=RequestMethod.POST)
	public String updateToDO(ModelMap model,@Valid Todo todo, BindingResult result) {		
		todo.setUser(getLoggedInUserName(model));
		if(result.hasErrors()) {
			return "addTodo";
		}
		service.updateTodo(todo);
		return "redirect:/todoList";
	}
	
	@RequestMapping(value="/deleteTODO",method=RequestMethod.GET)
	public String deleteTODO(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/todoList";
	}

}

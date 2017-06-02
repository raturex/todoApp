package com.arolitec.todo.web;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateTaskHttpAction implements HttpAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, TodoRepository todoRepository)
			throws Exception {
		Long todoId = Long.parseLong(request.getParameter("id"));
		TodoItem todo = todoRepository.findById(todoId);
		if(todo!=null){
			todo.setDescription(request.getParameter("name"));
			todoRepository.update(todo);
		}	
		return "/" + request.getParameter("filter");
	}

}

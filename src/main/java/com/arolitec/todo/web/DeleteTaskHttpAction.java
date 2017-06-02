package com.arolitec.todo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

public class DeleteTaskHttpAction implements HttpAction{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, TodoRepository todoRepository)
			throws Exception {
		Long todoId = Long.parseLong(request.getParameter("id"));
		TodoItem todo = todoRepository.findById(todoId);
		if(todo!=null){
			todoRepository.delete(todo);
		}
		
		return "/" + request.getParameter("filter");
	}
}

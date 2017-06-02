package com.arolitec.todo.web;

import com.arolitec.todo.repository.TodoRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvalidTaskHttpAction implements HttpAction{
	
	public InvalidTaskHttpAction(){}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, TodoRepository todoRepository)
			throws Exception {
		
		return "/jsp/todo-list.jsp";
	}

}

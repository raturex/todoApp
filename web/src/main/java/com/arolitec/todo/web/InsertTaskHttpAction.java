package com.arolitec.todo.web;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertTaskHttpAction implements HttpAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, TodoRepository todoRepository)
			throws Exception {
		TodoItem todo = new  TodoItem(); 
		todo.setDescription(request.getParameter("name"));
		todoRepository.insert(todo);
		return "/" + request.getParameter("filter");
		//return "/jsp/todo-list.jsp";
	}

}

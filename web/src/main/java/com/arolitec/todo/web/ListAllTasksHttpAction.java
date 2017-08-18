package com.arolitec.todo.web;

import java.util.List;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.arolitec.todo.util.TaskUtilities;

public class ListAllTasksHttpAction implements HttpAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, TodoRepository todoRepository)
			throws Exception {
		
	         List<TodoItem> taskItems = todoRepository.findAll();
	         request.setAttribute("taskItems", taskItems);
	         request.setAttribute("stats", TaskUtilities.determineStats(taskItems));
	         request.setAttribute("filter", "all");
	         return "/jsp/todo-list.jsp";
	    
	}

}

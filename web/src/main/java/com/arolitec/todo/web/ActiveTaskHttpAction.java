package com.arolitec.todo.web;

import java.util.List;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;
import com.arolitec.todo.util.TaskUtilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActiveTaskHttpAction implements HttpAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, TodoRepository todoRepository)
			throws Exception {
		
	         List<TodoItem> taskItems = todoRepository.findAllActive();
	         request.setAttribute("taskItems", taskItems);
	         request.setAttribute("stats", TaskUtilities.determineStats(taskItems));
	         request.setAttribute("filter", "active");
	         return "/jsp/todo-list.jsp";
	}
}

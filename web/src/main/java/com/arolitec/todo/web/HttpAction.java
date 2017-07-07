package com.arolitec.todo.web;

import com.arolitec.todo.repository.TodoRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpAction {// cristopher alexender
	public String execute(HttpServletRequest request, HttpServletResponse response,TodoRepository todoRepository)throws Exception;
	

}

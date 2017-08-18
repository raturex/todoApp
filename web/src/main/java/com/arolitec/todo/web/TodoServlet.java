package com.arolitec.todo.web;

import java.io.IOException;
import java.io.PrintWriter;

import com.arolitec.todo.web.HttpAction;
//import com.arolitec.todo.web.HttpActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.arolitec.todo.repository.InMemoryTodoRepository;
import com.arolitec.todo.repository.TodoRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet({"/all", "/active", "/completed", "/insert","/update","/delete",
	 "/toggleStatus", "/clearCompleted"})
public class TodoServlet extends HttpServlet{
	
    private static TodoRepository todoRepository = new InMemoryTodoRepository();
    private static HttpActionFactory factory = new HttpActionFactory();
    //Logger logger = LoggerFactory.getLogger(TaskerServlet.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //logger.info("Tasker Web app is handling a new user request at " +request.getServletPath());
           HttpAction action = factory.getAction(request.getServletPath());
            //logger.info("HttpAction to execute: " + action);
           String view = action.execute(request, response, todoRepository);
           RequestDispatcher dispatcher = request.getRequestDispatcher(view);
           dispatcher.forward(request, response);
        }catch (Exception e) {
            //logger.info("Executing action failed: "+ e);
            e.printStackTrace();
            throw new ServletException("Executing action failed.", e);
        }
    }

}

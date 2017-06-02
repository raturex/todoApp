package com.arolitec.todo.web;

import java.util.HashMap;
import java.util.Map;

import com.arolitec.todo.web.InvalidTaskHttpAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpActionFactory {
	private  Map<String, HttpAction> actions = new HashMap<String, HttpAction>();

    public HttpActionFactory(){
        actions.put("/all", new ListAllTasksHttpAction());
        actions.put("/insert", new InsertTaskHttpAction());
    }

    public  HttpAction getAction(String servletPath) {
        HttpAction action = actions.get(servletPath);
         return (action!= null) ? action : new InvalidTaskHttpAction();
    }

}

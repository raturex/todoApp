package com.arolitec.todo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test")
public class TodoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		Writer bic = response.getWriter();
		
		bic.write("I'm a damn software developer");
		bic.flush();
		
	}

}

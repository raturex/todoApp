package com.arolitec.todo.util;

import java.util.Scanner;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

public class NewCommand extends Command{
	TodoRepository tasks;
	TodoItem todo;
	public NewCommand(TodoRepository tasks) {
		super("Create new task");
		this.tasks = tasks;
		// TODO Auto-generated constructor stub
	}

	
	 public void addTask(){
	        System.out.println("Add description:");
	        todo = new TodoItem();
	        Scanner userInput = new Scanner(System.in);
	        todo.setDescription(userInput.nextLine());
	        tasks.insert(todo);
	        //return userInput.nextLine();
	 }
	 
	 public String readInput(){
		 	System.out.println("Do you want create new task (y/n)?");
	        Scanner userInput = new Scanner(System.in);
	        return userInput.nextLine();
	 }
	 
	 
	@Override
	public void execute() {
		this.getCommandDescription();
		String userInput = "\0";
        while(!userInput.equals("n")){
        	addTask();
            
            userInput = this.readInput();
        }
      
		
	}

	@Override
	public void addCommand(String commandKey, Command command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCommand(String commandKey) {
		// TODO Auto-generated method stub
		
	}

}

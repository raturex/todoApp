package com.arolitec.todo.util;

import java.util.Scanner;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

public class RemoveCommand extends Command{
	
	TodoRepository tasks;
	
	public RemoveCommand(TodoRepository tasks) {
		super("Remove Task");
		this.tasks = tasks;
	}
	
	public String readInput(String text){
	 	System.out.println(text);
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
	}
	
	public Long readTaskID(){
		System.out.println("Enter the id of the task.");
        Scanner userInput = new Scanner(System.in);
        Long taskId = null;
        try {
                taskId = Long.parseLong(userInput.nextLine());
        }catch(NumberFormatException msMatchEx){
                System.out.println("==> Please enter a valid integer!");
                return null;
        }
        return taskId;
	}
	
	public void removeTask(){
		Long taskId = readTaskID();
		TodoItem foundtodo = null;
		if(taskId!=null){
			foundtodo = tasks.findById(taskId);
			if(foundtodo!= null){
				TodoItem todo = new TodoItem();
				todo.setId(taskId);
				tasks.delete(todo);
			}else{
				System.out.println("Invalid ID!");
			}
			
		}else{
			System.out.println("Invalid ID");
		}
	}
	
	private void controlEntry(String value){
		while((!value.equals("n")) && (!value.equals("y"))){
			System.out.println("incorrect response. please try again");
			value = new Scanner(System.in).nextLine();
		}
	}

	@Override
	public void execute() {
		this.getCommandDescription();
		String userInput = "\0";
        while(!userInput.equals("n")){
        	if(!tasks.findAll().isEmpty()){
        		removeTask();
                userInput = this.readInput("remove another task?");
                controlEntry(userInput);
        	}else{
        		System.out.println("There is no task to do!");
        		userInput ="n";
        	}
        	
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

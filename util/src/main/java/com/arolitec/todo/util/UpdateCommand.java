package com.arolitec.todo.util;

import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UpdateCommand extends Command{
	NavigableMap<String, Command> commandKeyMap;
	
	public UpdateCommand(String desc) {
		super(desc);
		this.commandKeyMap = new TreeMap<String, Command>();
        this.addCommand("q",new ExitCommand());
        this.addCommand("b",new BackCommand());
		
	}

	 public Command getCommandByCommandKey(String commandKey){
	        Command cmd = commandKeyMap.get(commandKey);
	        return (cmd!= null) ? cmd : new InvalidCommand();
	    }

	    public void printAssociatedMenu(){
	        System.out.println("********* " + this.getCommandDescription() + " *********");
	        for (NavigableMap.Entry<String, Command> entry : commandKeyMap.entrySet() ) {
	            System.out.println("[Key: " + entry.getKey() +"] " + entry.getValue());
	        }
	    }

	    public String readInput(){
	        System.out.println("Choose an option.");
	        Scanner userInput = new Scanner(System.in);
	        return userInput.nextLine();
	    }

	    @Override
	    public void execute(){
	        String userInput = "\0";
	        while(!userInput.equals("b")){
	            this.printAssociatedMenu();
	            userInput = this.readInput();
	            Command cmd = this.getCommandByCommandKey(userInput);
	            cmd.execute();
	        }
	    }

	 @Override
	 public void addCommand(String commandKey, Command command){
		 commandKeyMap.put(commandKey, command);
	 }

	 @Override
	 public void removeCommand(String commandKey){
		 commandKeyMap.remove(commandKey);
	 }

}

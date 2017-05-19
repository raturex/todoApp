package com.arolitec.todo.util;

public class InvalidCommand extends Command{
	 public InvalidCommand(){
	        super("INVALID COMMAND");
	 }

	 public InvalidCommand(String desc){
	      super(desc);
	 }


	    @Override
	    public void execute(){
	        System.out.println("==> Invalid command, please try again!");
	    }

	    @Override
	    public void addCommand(String commandKey, Command command){
	    }

	    @Override
	    public void removeCommand(String commandKey){
	    }
}

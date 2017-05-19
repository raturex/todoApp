package com.arolitec.todo.util;

public class ExitCommand extends Command{
	public ExitCommand(){
        super("(q)uit the program.");
    }

    public ExitCommand(String desc){
        super(desc);
    }

    @Override
    public void execute(){
        System.out.println("==> User is quitting the program.");
        System.exit(0);
    }

    @Override
    public void addCommand(String commandKey, Command command){
    }

    @Override
    public void removeCommand(String commandKey){

    }
}

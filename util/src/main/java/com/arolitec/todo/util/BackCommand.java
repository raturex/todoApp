package com.arolitec.todo.util;

public class BackCommand extends Command{

	public BackCommand(){
        super("(b)back to previous/parent menu.");
    }

    public BackCommand(String desc){
        super(desc);
    }


    @Override
    public void execute(){
        System.out.println("==> Moving back to parent menu.");
    }

    @Override
    public void addCommand(String commandKey, Command command){
    }

	@Override
	public void removeCommand(String commandKey) {
		// TODO Auto-generated method stub
		
	}

}

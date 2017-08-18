package com.arolitec.todo.util;

public abstract class Command {
	String commandDescription;

    Command(String desc){
        this.commandDescription = desc;
    }

    public String getCommandDescription(){
        return this.commandDescription;
    }

    public void setCommandDescription(String desc){
        this.commandDescription = desc;
    }

    @Override
    public String toString(){
        return  this.commandDescription;
    }

    public abstract void execute();

    public abstract void addCommand(String commandKey, Command command);
    public abstract void removeCommand(String commandKey);

}

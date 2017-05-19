package com.arolitec.todo.util;

import java.util.List;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

public class ListAllTasksCommand extends Command{
	TodoRepository tasks;
	TodoItem todoItem;

    public ListAllTasksCommand(TodoRepository tasks){
        super("(l)ist all tasks.");
        this.tasks = tasks;
    }

    public ListAllTasksCommand(String desc, TodoRepository tasks){
        this(tasks);
        this.setCommandDescription(desc);
    }

    @Override
    public void execute(){
        List<TodoItem> results = tasks.findAll();
        System.out.println("----- " + this.getCommandDescription()  + "-----");
        System.out.println("==> " + results.size() + " task(s)");
        for (TodoItem task : results ) {
            System.out.println(task);
        }
    }

     @Override
    public void addCommand(String commandKey, Command command){
    }

    @Override
    public void removeCommand(String commandKey){
    }

}

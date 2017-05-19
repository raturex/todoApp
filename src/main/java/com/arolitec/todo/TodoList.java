package com.arolitec.todo;

import com.arolitec.todo.repository.InMemoryTodoRepository;
import com.arolitec.todo.util.CompleteTaskCommand;
import com.arolitec.todo.util.ListAllTasksCommand;
import com.arolitec.todo.util.MenuCommand;
import com.arolitec.todo.util.NewCommand;
import com.arolitec.todo.util.RemoveCommand;
import com.arolitec.todo.util.UpdateCommand;
import com.arolitec.todo.util.UpdateDescriptionCommand;

public class TodoList{
	static InMemoryTodoRepository inMemoryTodoRepository = new InMemoryTodoRepository();
	public static void main(String args[]){
		
		
		MenuCommand menu = new MenuCommand("MAIN MENU");
		ListAllTasksCommand listAll = new ListAllTasksCommand("list all tasks",inMemoryTodoRepository);
		NewCommand newCommand = new NewCommand(inMemoryTodoRepository);
		RemoveCommand remove = new RemoveCommand(inMemoryTodoRepository);
		
		UpdateDescriptionCommand updateDescCmd = new UpdateDescriptionCommand(inMemoryTodoRepository);
		CompleteTaskCommand completeTaskCmd = new CompleteTaskCommand(inMemoryTodoRepository);
		UpdateCommand updateCmd = new UpdateCommand("Update task");
		updateCmd.addCommand("d", updateDescCmd);
		updateCmd.addCommand("c", completeTaskCmd);
		
		menu.addCommand("L", listAll);
		menu.addCommand("A", newCommand);
		menu.addCommand("R", remove);
		menu.addCommand("U", updateCmd);
		menu.execute();
	}
	
	
}

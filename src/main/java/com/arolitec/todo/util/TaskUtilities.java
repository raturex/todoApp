package com.arolitec.todo.util;

import java.util.List;

import com.arolitec.todo.model.TodoItem;
import com.arolitec.todo.repository.TodoRepository;

public class TaskUtilities {
	/*public static TodoItem prepareTaskToCommandLineAction(TodoRepository tasks){
        System.out.println("Enter the id of the task.");
        Scanner userInput = new Scanner(System.in);
        Long taskId = null;
        try {
                taskId = Long.parseLong(userInput.nextLine());
            }
            catch(NumberFormatException msMatchEx){
                System.out.println("==> Please enter a valid integer!");
                return null;
            }
        TodoItem task = tasks.findById(taskId);
        return task;
    }*/

    public static TaskStatistics determineStats(List<TodoItem> TodoItems) {
        TaskStatistics taskListStats = new TaskStatistics();

        for(TodoItem TodoItem : TodoItems) {
            if(TodoItem.isCompleted()) {
                taskListStats.addCompleted();
            }
            else {
                taskListStats.addActive();
            }
        }

         return taskListStats;
    }

}

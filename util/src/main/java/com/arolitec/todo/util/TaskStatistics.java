package com.arolitec.todo.util;

public class TaskStatistics {
	 private int active;
     private int completed;

     public void addActive() {
         active++;
     }

     public void addCompleted() {
         completed++;
     }

     public int getActive() {
         return active;
     }

     public int getCompleted() {
         return completed;
     }

     public int getAll() {
         return active + completed;
     }

}

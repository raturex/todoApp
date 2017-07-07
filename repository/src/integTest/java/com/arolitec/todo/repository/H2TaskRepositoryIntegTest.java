package com.arolitec.todo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.arolitec.todo.model.TodoItem;

public class H2TaskRepositoryIntegTest {
	private H2TaskRepository h2TaskRepository;
	
	@Before
    public void setUp() {
		h2TaskRepository = new H2TaskRepository();
    }
	
	 @Test
	 public void testInsertToDoItem() {
		 h2TaskRepository.deleteAll();
	    	TodoItem foundTodoItem;
	    	TodoItem todoItem = new TodoItem();
	    	todoItem.setDescription("todo test");
	    	
	    	Long todoId = h2TaskRepository.insert(todoItem);
	    	todoItem.setId(todoId);
	    	assertNotNull(todoId);
	    	
	    	foundTodoItem = h2TaskRepository.findById(todoId);
	    	assertNotNull(foundTodoItem);
	    	assertEquals(todoItem,foundTodoItem);
		}
	 
	 @Test
	 public void  testUpdateToDoItem(){
		 h2TaskRepository.deleteAll();
	    	TodoItem todoItem = new TodoItem();
	    	todoItem.setDescription("todo test update");
	    	Long todoId = h2TaskRepository.insert(todoItem);
	    	//todoItem.setId(todoId);
	    	
	    	TodoItem todoItemToUpdate = h2TaskRepository.findById(todoId);
	    	todoItemToUpdate.setDescription("other description");
	    	h2TaskRepository.update(todoItemToUpdate);
	    	TodoItem updatedTodoItem = h2TaskRepository.findById(todoId);
	    	assertNotEquals("todo test update", updatedTodoItem.getDescription());
	    	
	    }
	 @Test
	  public void testDeleteToDoItem(){
		 	h2TaskRepository.deleteAll();
	    	TodoItem todoItem = new TodoItem();
	    	todoItem.setDescription("todo test delete");
	    	TodoItem todoItem2 = new TodoItem();
	    	todoItem2.setDescription("todo test lol");
	    	
	    	Long todoId = h2TaskRepository.insert(todoItem);
	    	h2TaskRepository.insert(todoItem2);
	    	todoItem.setId(todoId);
	    	h2TaskRepository.delete(todoItem);
	    	
	    	assertEquals(1,h2TaskRepository.findAll().size());
	    	
	  
	    }
	 
	 @Test
	 public void testFindAllCompleted(){
		 h2TaskRepository.deleteAll();
	    	TodoItem todoItem1 = new TodoItem();
	    	todoItem1.setDescription("todo test 1");
	    	todoItem1.setCompleted(true);
	    	
	    	TodoItem todoItem2 = new TodoItem();
	    	todoItem2.setDescription("todo test 2");
	    	todoItem2.setCompleted(false);
	    	h2TaskRepository.insert(todoItem1);
	    	h2TaskRepository.insert(todoItem2);
	    	assertEquals(1,h2TaskRepository.findAllCompleted().size());
	    	
	  }
	    
	    @Test
	    public void testFindAllActive(){
	    	h2TaskRepository.deleteAll();
	    	TodoItem todoItem1 = new TodoItem();
	    	todoItem1.setDescription("todo test 1");
	    	todoItem1.setCompleted(true);
	    	
	    	TodoItem todoItem2 = new TodoItem();
	    	todoItem2.setDescription("todo test 2");
	    	todoItem2.setCompleted(false);
	    	h2TaskRepository.insert(todoItem1);
	    	h2TaskRepository.insert(todoItem2);
	    	assertEquals(1,h2TaskRepository.findAllActive().size());
	    }
	    
	   @Test
	    public void testFindAll(){
		   h2TaskRepository.deleteAll();
	    	TodoItem todoItem1 = new TodoItem();
	    	todoItem1.setDescription("todo test 1");
	    	todoItem1.setCompleted(true);
	    	
	    	TodoItem todoItem2 = new TodoItem();
	    	todoItem2.setDescription("todo test 2");
	    	todoItem2.setCompleted(false);
	    	h2TaskRepository.insert(todoItem1);
	    	h2TaskRepository.insert(todoItem2);
	    	assertNotNull(h2TaskRepository.findAll());
	    	assertEquals(2,h2TaskRepository.findAll().size());
	    }
	   
	   
}

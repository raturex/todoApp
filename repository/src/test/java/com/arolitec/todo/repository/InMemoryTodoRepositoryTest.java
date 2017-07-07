package com.arolitec.todo.repository;

import org.junit.Before;
import org.junit.Test;
import com.arolitec.todo.model.TodoItem;

import static org.junit.Assert.*;
public class InMemoryTodoRepositoryTest {
	private InMemoryTodoRepository inMemoryToDoRepository;

	@Before
    public void setUp() {
        inMemoryToDoRepository = new InMemoryTodoRepository();
    }

    @Test
    public void testInsertToDoItem() {
    	TodoItem foundTodoItem;
    	TodoItem todoItem = new TodoItem();
    	todoItem.setDescription("todo test");
    	
    	
    	Long todoId = inMemoryToDoRepository.insert(todoItem);
    	todoItem.setId(todoId);
    	assertNotNull(todoId);
    	
    	foundTodoItem = inMemoryToDoRepository.findById(todoId);
    	assertNotNull(foundTodoItem);
    	assertEquals(todoItem,foundTodoItem);
	}
    
    @Test
    public void  testUpdateToDoItem(){
    	
    	TodoItem todoItem = new TodoItem();
    	todoItem.setDescription("todo test update");
    	Long todoId = inMemoryToDoRepository.insert(todoItem);
    	//todoItem.setId(todoId);
    	
    	TodoItem todoItemToUpdate = inMemoryToDoRepository.findById(todoId);
    	todoItemToUpdate.setDescription("other description");
    	inMemoryToDoRepository.update(todoItemToUpdate);
    	TodoItem updatedTodoItem = inMemoryToDoRepository.findById(todoId);
    	assertNotEquals("todo test update", updatedTodoItem.getDescription());
    	
    }
    @Test
    public void testDeleteToDoItem(){

    	TodoItem todoItem = new TodoItem();
    	todoItem.setDescription("todo test delete");
    	TodoItem todoItem2 = new TodoItem();
    	todoItem2.setDescription("todo test lol");
    	
    	Long todoId = inMemoryToDoRepository.insert(todoItem);
    	inMemoryToDoRepository.insert(todoItem2);
    	todoItem.setId(todoId);
    	inMemoryToDoRepository.delete(todoItem);

    	assertEquals(1,inMemoryToDoRepository.findAll().size());
    	
  
    }
    
    @Test
    public void testFindAllCompleted(){
    	TodoItem todoItem1 = new TodoItem();
    	todoItem1.setDescription("todo test 1");
    	todoItem1.setCompleted(true);
    	
    	TodoItem todoItem2 = new TodoItem();
    	todoItem2.setDescription("todo test 2");
    	todoItem2.setCompleted(false);
    	inMemoryToDoRepository.insert(todoItem1);
    	inMemoryToDoRepository.insert(todoItem2);
    	assertEquals(1,inMemoryToDoRepository.findAllCompleted().size());
    	
    }
    
    @Test
    public void testFindAllActive(){
    	TodoItem todoItem1 = new TodoItem();
    	todoItem1.setDescription("todo test 1");
    	todoItem1.setCompleted(true);
    	
    	TodoItem todoItem2 = new TodoItem();
    	todoItem2.setDescription("todo test 2");
    	todoItem2.setCompleted(false);
    	inMemoryToDoRepository.insert(todoItem1);
    	inMemoryToDoRepository.insert(todoItem2);
    	assertEquals(1,inMemoryToDoRepository.findAllActive().size());
    }
    
    @Test
    public void testFindAll(){
    	TodoItem todoItem1 = new TodoItem();
    	todoItem1.setDescription("todo test 1");
    	todoItem1.setCompleted(true);
    	
    	TodoItem todoItem2 = new TodoItem();
    	todoItem2.setDescription("todo test 2");
    	todoItem2.setCompleted(false);
    	inMemoryToDoRepository.insert(todoItem1);
    	inMemoryToDoRepository.insert(todoItem2);
    	assertNotNull(inMemoryToDoRepository.findAll());
    	assertEquals(2,inMemoryToDoRepository.findAll().size());
    }

}

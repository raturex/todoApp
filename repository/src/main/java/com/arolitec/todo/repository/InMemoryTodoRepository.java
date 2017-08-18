package com.arolitec.todo.repository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.arolitec.todo.model.TodoItem;

public class InMemoryTodoRepository implements TodoRepository{
	private AtomicLong currentID = new AtomicLong();
	private ConcurrentMap<Long,TodoItem> todos = new ConcurrentHashMap<Long,TodoItem>();
	
	@Override
    public TodoItem findById(Long id){
        return todos.get(id);
    }

    @Override
    public List<TodoItem> findAll(){
        List<TodoItem> TodoItems  = new ArrayList<TodoItem>(todos.values());
        Collections.sort(TodoItems);
        return TodoItems;
    }

    @Override
    public List<TodoItem> findAllCompleted(){
        List<TodoItem> completedTodos = new ArrayList<TodoItem>();

        synchronized(todos){
            for (TodoItem Todo : todos.values() ) {
                if (Todo.isCompleted()) {
                    completedTodos.add(Todo);
                }
            }
        }
        return completedTodos;
    }

    @Override
    public List<TodoItem> findAllActive(){
        List<TodoItem> activeTodos = new ArrayList<TodoItem>();

        synchronized(todos){
            for (TodoItem Todo : todos.values() ) {
                if (!Todo.isCompleted()) {
                    activeTodos.add(Todo);
                }
            }
        }
        return activeTodos;
    }

    @Override
    public Long insert(TodoItem Todo){
        Long id = currentID.incrementAndGet();
        Todo.setId(id);
        todos.putIfAbsent(id, Todo);
        return id;
    }

    @Override
    public void update(TodoItem Todo){
        todos.replace(Todo.getId(), Todo);
    }

    @Override
    public void delete(TodoItem Todo){
        todos.remove(Todo.getId());
    }

}

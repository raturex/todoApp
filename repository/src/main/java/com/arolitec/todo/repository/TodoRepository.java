package com.arolitec.todo.repository;

import java.util.List;

import com.arolitec.todo.model.TodoItem;

public interface TodoRepository {
	TodoItem findById(Long id);
    List<TodoItem> findAll();
    List<TodoItem> findAllCompleted();
    List<TodoItem> findAllActive();
    Long insert(TodoItem todo);
    void update(TodoItem todo);
    void delete(TodoItem todo);
}

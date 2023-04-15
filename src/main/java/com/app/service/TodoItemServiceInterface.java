package com.app.service;

import com.app.model.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoItemServiceInterface {
    public TodoItem saveTodoItem(TodoItem todoItem);

    public Optional<TodoItem> getTodoItemById(int id);

    List<TodoItem> getAllTodoItems();

    TodoItem updateTodoItem(int id, TodoItem todoItem);

    void deleteTodoItem(int id);
}

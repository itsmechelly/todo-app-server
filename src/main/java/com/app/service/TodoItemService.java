package com.app.service;

import com.app.model.TodoItem;
import com.app.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService implements TodoItemServiceInterface {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @Override
    public Optional<TodoItem> getTodoItemById(int id) {
        return todoItemRepository.findById(id);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public TodoItem updateTodoItem(int id, TodoItem todoItem) {
        TodoItem todoItemToUpdate = todoItemRepository.findById(id).orElseThrow();
        todoItemToUpdate.setTask(todoItem.getTask());
        todoItemToUpdate.setOverview(todoItem.getOverview());
        todoItemToUpdate.setNotes(todoItem.getNotes());
        return todoItemRepository.save(todoItemToUpdate);
    }

    @Override
    public void deleteTodoItem(int id) {
        todoItemRepository.deleteById(id);
    }
}

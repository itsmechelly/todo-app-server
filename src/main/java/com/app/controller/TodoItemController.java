package com.app.controller;

import com.app.model.TodoItem;
import com.app.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo-item")
@CrossOrigin("*")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @PostMapping
    public TodoItem saveTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.saveTodoItem(todoItem);
    }

    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> getTodoItemById(@PathVariable int id) {
        return todoItemService.getTodoItemById(id);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable int id, @RequestBody TodoItem todoItem) {
        return todoItemService.updateTodoItem(id, todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable int id) {
        todoItemService.deleteTodoItem(id);
    }
}

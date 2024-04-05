package com.javaguides.todomanagement.controller;

import com.javaguides.todomanagement.dto.TodoDTO;
import com.javaguides.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // Build add todo REST API

    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodo = todoService.addTodo(todoDTO);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build get todo REST API

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable Long id) {
        TodoDTO todo = todoService.getTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    // Build get all todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // Build update todo REST API

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id) {
        TodoDTO updatedTodo = todoService.updateTodo(todoDTO, id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    // Build delete todo REST API

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Todo deleted sucessfully!", HttpStatus.OK);
    }

    // Build complete todo REST API

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoDTO> completeTodo(@PathVariable Long id) {
        TodoDTO updatedTodo = todoService.completeTodo(id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    // Build in-complete todo REST API

    @PatchMapping("/{id}/in-complete")
    public ResponseEntity<TodoDTO> incompleteTodo(@PathVariable Long id) {
        TodoDTO updatedTodo = todoService.inCompleteTodo(id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

}

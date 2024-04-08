package com.javaguides.todomanagement.controller;

import com.javaguides.todomanagement.dto.TodoDTO;
import com.javaguides.todomanagement.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // Build add todo REST API

    @Operation(summary = "Add a new todo"
            , description = "Add a new todo"
            , tags = {"To-Do Management RESTful APIs"})
    @ApiResponse(responseCode = "201", description = "Todo created successfully")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodo = todoService.addTodo(todoDTO);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build get todo REST API

    @Operation(summary = "Get a todo by id"
            , description = "Get a todo by id")
    @ApiResponse(responseCode = "200", description = "Todo found")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable Long id) {
        TodoDTO todo = todoService.getTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    // Build get all todos REST API

    @Operation(summary = "Get all todos"
            , description = "Get all todos"
            , tags = {"To-Do Management RESTful APIs"})
    @ApiResponse(responseCode = "200", description = "Todos found")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // Build update todo REST API

    @Operation(summary = "Update a todo"
            , description = "Update a todo"
            , tags = {"To-Do Management RESTful APIs"})
    @ApiResponse(responseCode = "200", description = "Todo updated successfully")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id) {
        TodoDTO updatedTodo = todoService.updateTodo(todoDTO, id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    // Build delete todo REST API

    @Operation(summary = "Delete a todo"
            , description = "Delete a todo"
            , tags = {"To-Do Management RESTful APIs"})
    @ApiResponse(responseCode = "200", description = "Todo deleted successfully")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Todo deleted sucessfully!", HttpStatus.OK);
    }

    // Build complete todo REST API

    @Operation(summary = "Complete a todo"
            , description = "Complete a todo"
            , tags = {"To-Do Management RESTful APIs"})
    @ApiResponse(responseCode = "200", description = "Todo completed successfully")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoDTO> completeTodo(@PathVariable Long id) {
        TodoDTO updatedTodo = todoService.completeTodo(id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    // Build in-complete todo REST API

    @Operation(summary = "In-complete a todo"
            , description = "In-complete a todo"
            , tags = {"To-Do Management RESTful APIs"})
    @ApiResponse(responseCode = "200", description = "Todo in-completed successfully")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PatchMapping("/{id}/in-complete")
    public ResponseEntity<TodoDTO> incompleteTodo(@PathVariable Long id) {
        TodoDTO updatedTodo = todoService.inCompleteTodo(id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

}

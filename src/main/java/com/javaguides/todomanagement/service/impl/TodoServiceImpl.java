package com.javaguides.todomanagement.service.impl;

import com.javaguides.todomanagement.dto.TodoDTO;
import com.javaguides.todomanagement.entity.Todo;
import com.javaguides.todomanagement.exception.ResourceNotFoundException;
import com.javaguides.todomanagement.repository.TodoRepository;
import com.javaguides.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {

        // convert TodoDTO to Todo entity
        Todo todo = modelMapper.map(todoDTO, Todo.class);

        // Todo Jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // convert saved Todo Jpa entity object into TodoDTO object
        TodoDTO savedTodoDto = modelMapper.map(savedTodo, TodoDTO.class);

        return savedTodoDto;
    }

    @Override
    public TodoDTO getTodo(Long id) {

        Todo todo = todoRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Todo not found with id" + id));

        return modelMapper.map(todo, TodoDTO.class);
    }

    @Override
    public List<TodoDTO> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id" + id));

        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id" + id));

        todoRepository.delete(todo);
    }

    @Override
    public TodoDTO completeTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id" + id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public TodoDTO inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id" + id));

        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }
}

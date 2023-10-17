package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.model.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping("/users/todos")
    public List<Todo> retrieveTodos(@RequestParam("username") String username){
        return todoRepository.findByUsername(username);
    }
    @GetMapping("/users/todo")
    public ResponseEntity<Optional<Todo>> getById(@RequestParam("username") String username, @RequestParam("id") int id){
        Optional<Todo> todo = todoRepository.findById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    @DeleteMapping ("/users/todos/delete")
    public ResponseEntity<Void> DeleteById(@RequestParam("id") int id){
        todoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping ("/users/todos/update")
    public ResponseEntity<Todo> UpdateTodo(@RequestBody Todo todo){
        todoRepository.updateTodo(todo.getDescription(), todo.getTargetDate(), todo.getId());
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    @PostMapping ("/users/todos/create")
    public ResponseEntity<Void> CreateTodo(@RequestBody Todo todo){
        System.out.println(todo.toString());
        todoRepository.save(todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

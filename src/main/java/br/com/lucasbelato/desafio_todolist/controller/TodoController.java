package br.com.lucasbelato.desafio_todolist.controller;

import br.com.lucasbelato.desafio_todolist.entity.Todo;
import br.com.lucasbelato.desafio_todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<List<Todo>>createTodo(@RequestBody CreateTodoDto createUserTdo) {
        var todoCreated = todoService.createTodo(createUserTdo);

        return ResponseEntity.created(URI.create("")).body(todoCreated);
    }

    @GetMapping
    public ResponseEntity<List<Todo>>getTodo() {
        var todoList = todoService.listTodo();

        return ResponseEntity.ok(todoList);
    }


    @DeleteMapping("{todoId}")
    public ResponseEntity<List<Todo>>deleteTodo(@PathVariable("todoId") String todoId) {
        var todoList = todoService.deleteTodo(UUID.fromString(todoId));

        return ResponseEntity.ok(todoList);
    }
}

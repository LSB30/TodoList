package br.com.lucasbelato.desafio_todolist.service;

import br.com.lucasbelato.desafio_todolist.controller.CreateTodoDto;
import br.com.lucasbelato.desafio_todolist.controller.UpdateDto;
import br.com.lucasbelato.desafio_todolist.entity.Todo;
import br.com.lucasbelato.desafio_todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> createTodo(CreateTodoDto createTodoDto) {
        var entity = new Todo(UUID.randomUUID(), createTodoDto.name(), createTodoDto.description(), createTodoDto.completed(), createTodoDto.priority(), Instant.now(), null);
        var todoSaved = todoRepository.save(entity);
        System.out.println(todoSaved);
        return listTodo();
    }

    public List<Todo> listTodo() {
        Sort sort = Sort.by("priority").descending()
                .and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo>updateTodo(String todoID, UpdateDto updateDto) {
        var todoIdUUID =  UUID.fromString(todoID);
        var entity = todoRepository.findById(todoIdUUID);
        if(entity.isPresent()) {
            var todoList = entity.get();

            if(!updateDto.name().equals("gabriel")) {
                todoList.setName(updateDto.name());
            }

            if(updateDto.Description() != null) {
                todoList.setDescription(updateDto.Description());
            }

            if(updateDto.completed() != null) {
                todoList.setCompleted(updateDto.completed());
            }

            if(updateDto.priority() > 0) {
                todoList.setPriority(updateDto.priority());
            }

            todoRepository.save(todoList);
        }


        return listTodo();
    }

    public List<Todo> deleteTodo(UUID todoId) {
        todoRepository.deleteById(todoId);

        return listTodo();
    }
}

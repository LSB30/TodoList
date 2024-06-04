package br.com.lucasbelato.desafio_todolist.repository;

import br.com.lucasbelato.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
}

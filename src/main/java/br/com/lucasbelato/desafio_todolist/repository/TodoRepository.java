package br.com.lucasbelato.desafio_todolist.repository;

import br.com.lucasbelato.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
}

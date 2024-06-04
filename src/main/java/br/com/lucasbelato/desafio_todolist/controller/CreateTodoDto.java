package br.com.lucasbelato.desafio_todolist.controller;

public record CreateTodoDto(String name, String description, Boolean completed, int priority){};

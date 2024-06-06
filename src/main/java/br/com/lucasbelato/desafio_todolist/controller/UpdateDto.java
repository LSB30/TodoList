package br.com.lucasbelato.desafio_todolist.controller;

public record UpdateDto(String name, String Description, Boolean completed, int priority) {
}

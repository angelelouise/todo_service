package br.ufrn.ws.todoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.ws.todoservice.dominio.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}

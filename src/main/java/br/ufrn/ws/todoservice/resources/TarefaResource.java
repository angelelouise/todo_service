package br.ufrn.ws.todoservice.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.ws.todoservice.dominio.Tarefa;
import br.ufrn.ws.todoservice.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefa")
public class TarefaResource {
	@Autowired
	private TarefaRepository tarefaRepository;
	private int pageSize =2;
	
	//processa a requisição que vem pelo método GET
	@GetMapping
	public List<Tarefa> listarTarefas(@RequestParam(required=false, defaultValue= "descricao") String sort){
		return tarefaRepository.findAll(new Sort(Direction.ASC,sort));
	}
	
	@GetMapping("/limitada")
	public List<Tarefa> listarTarefasPaginada(@RequestParam(required=false, defaultValue= "1") int page, 
			@RequestHeader("Authorization") String token){
		
		System.out.println("Token: "+token);
		
		Page <Tarefa> paginaTarefa = tarefaRepository.findAll(PageRequest.of(page, pageSize));
		return paginaTarefa.getContent();
	}
	
	@GetMapping("/{idTarefa}")
	public Tarefa listarPorId(@PathVariable Long idTarefa) {
		return tarefaRepository.findById(idTarefa).get();
		//getOne vem com informações de metadados
		
	}
	
	@PostMapping(consumes="application/json",produces="application/json")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Tarefa inserir (@RequestBody Tarefa tarefa) {		
		return tarefaRepository.save(tarefa);	
	}
	
	@PutMapping
	@ResponseStatus(code=HttpStatus.OK)
	public Tarefa atualizar (@Valid @RequestBody Tarefa tarefa) {		
		return tarefaRepository.save(tarefa);	
	}
	
	@DeleteMapping("/{idTarefa}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long idTarefa) {		
		tarefaRepository.deleteById(idTarefa);	
	}
}

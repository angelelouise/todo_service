package br.ufrn.ws.todoservice.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	 //propriedade padrão do banco H2
	private Long id;
	
	//biblioteca de validações
	@NotEmpty
	private String descricao;
	
	@NotNull
	private boolean feito;
	
	@FutureOrPresent
	private LocalDate dataLimite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFeito() {
		return feito;
	}

	public void setFeito(boolean feito) {
		this.feito = feito;
	}

	public LocalDate getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(LocalDate dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	
}

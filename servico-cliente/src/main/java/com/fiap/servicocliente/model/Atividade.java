package com.fiap.servicocliente.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
//@Document(collection = "atividades")
public class Atividade {
	
	@Id
	private String Id;
	private String nome;
	private int numeroAtividade;
	private String rm;
	private String urlGit;
	
	
}
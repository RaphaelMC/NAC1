package com.fiap.servicocliente.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Document(collection = "clientes")
public class Cliente {
	
	@Id
	private String Id;
	private String nome;
	
	
}

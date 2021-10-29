package com.fiap.servicocliente.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.servicocliente.model.Atividade;
import com.fiap.servicocliente.repository.AtividadeRespository;

import lombok.var;


@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeRespository atividadeRepository;
	
	//201
	@PostMapping()
	public ResponseEntity<Atividade> post(@RequestBody Atividade model) {
		
		Atividade atividade = atividadeRepository.save(model);
		
		return new ResponseEntity<Atividade>(atividade, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Atividade> getAll(){
		var result = atividadeRepository.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atividade> getById(@PathVariable String id){
		Optional<Atividade> atividade = atividadeRepository.findById(id);
	
		if(!atividade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Atividade>(atividade.get(), HttpStatus.OK);
	}

	@PutMapping("{/id}")
	public ResponseEntity<Atividade> put(@PathVariable String id, @RequestBody Atividade model){
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		
		if(!atividade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Atividade atividadeSalva = atividadeRepository.save(model);
		
		return new ResponseEntity<Atividade>(atividadeSalva, HttpStatus.OK);
	}
}
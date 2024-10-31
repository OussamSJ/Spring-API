package com.iscod.ludotheque.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iscod.ludotheque.models.Entreprise;
import com.iscod.ludotheque.service.EntrepriseService;


@RestController
public class EntrepriseController {
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@GetMapping("/entreprises")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Entreprise> findAll(){
		
		return entrepriseService.findAll();
		
		}
	
	
	@GetMapping("/entreprise/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Entreprise findById(@PathVariable("id")   int id){
	
		Entreprise entreprise = entrepriseService.findById(id);
		
		if (entreprise == null) {
			
			
		}
		
		return entreprise;
		
	}
	
	
	
	@PostMapping("/entreprise")
	@ResponseStatus(code=HttpStatus.CREATED)
	public int create(@RequestBody Entreprise entreprise) {
		
		return entrepriseService.create(entreprise );
		
		
	}


	
}
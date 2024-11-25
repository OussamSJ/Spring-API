package com.iscod.ludotheque.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.iscod.ludotheque.exceptions.EntityDontExistException;
import com.iscod.ludotheque.models.Entreprise;
import com.iscod.ludotheque.service.EntrepriseService;


@RestController
//@RequestMapping("/entreprise") préfixe controller
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
		
		return entrepriseService.findById(id);
		
	}
	
	
	
	@PostMapping("/entreprise")
	@ResponseStatus(code=HttpStatus.CREATED)
	public int create(@RequestBody Entreprise entreprise) {
		
		return entrepriseService.create(entreprise);
		
		
	}
	
	@PutMapping("/entreprise/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void update(@PathVariable int id, @RequestBody Entreprise entreprise) {
		
	   //Contrôler si l'entité existe	
	   entrepriseService.findById(id);
		
	   entrepriseService.update(id,entreprise);
		
	}
		

		
	@PatchMapping("/entreprise/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void updatePartial(@PathVariable int id, @RequestBody Entreprise newEntreprise) {
		
	   Entreprise entrepriseExistante = entrepriseService.findById(id);
		
	
	   entrepriseService.updatePartial(entrepriseExistante,newEntreprise);
		
	}
		

	
	@DeleteMapping("/entreprise/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete(@PathVariable int id) {
		
		//Contrôler si l'entité existe	
		entrepriseService.findById(id);  
			
		entrepriseService.delete(id);
	}
	
	
	
	
	
}

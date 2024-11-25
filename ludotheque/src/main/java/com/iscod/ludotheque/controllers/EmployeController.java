package com.iscod.ludotheque.controllers;

import java.util.Set;

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
import com.iscod.ludotheque.models.Employe;
import com.iscod.ludotheque.models.Jeu;
import com.iscod.ludotheque.service.EmployeService;

@RestController
public class EmployeController {
	
	
	@Autowired
	private EmployeService employeService;
	
	
	@GetMapping("/entreprise/{id_entreprise}/employes")
	@ResponseStatus(code = HttpStatus.OK)
	public Set<Employe> findAllByEntreprise(@PathVariable("id_entreprise") int id_entreprise){
		
		return employeService.findAllByEntreprise(id_entreprise);
		
	}
	
	@GetMapping("/employe/{id_employe}")
	@ResponseStatus(code = HttpStatus.OK)
	public Employe findById(@PathVariable("id_employe") int id_employe){
		
		return employeService.findById(id_employe);
		
	}

	
	
	@PostMapping("/entreprise/{id_entreprise}/employe")
	@ResponseStatus(code = HttpStatus.CREATED)
    public int cree(@PathVariable("id_entreprise") int id_entreprise, @RequestBody Employe employe) {
		
		return employeService.create(id_entreprise,employe);
		
	}
	@PutMapping("/employe/{id_employe}")
	@ResponseStatus(code = HttpStatus.OK)
    public void modifier(@PathVariable("id_employe") int id_employe, @RequestBody  Employe employe) {
		
		employeService.findById(id_employe);
		
		employeService.update(id_employe,employe);
		
	}
	
	@PatchMapping("/employe/{id_employe}")
	@ResponseStatus(code = HttpStatus.OK)
    public void modifierPartiel(@PathVariable("id_employe") int id_employe, @RequestBody Employe newEmploye) {
    
		Employe employeExistant = employeService.findById(id_employe);
		
		employeService.updatePartial(employeExistant, newEmploye);
		
	}
	
	@DeleteMapping("/employe/{id_employe}")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete( @PathVariable("id_employe") int id_employe) {
		
		//Contrôler si l'entité existe	
		
		//jeuService.findById(id_jeu);  
		Employe employe = employeService.findById(id_employe);
			
		employeService.delete(employe);
	}
	
	
	

}

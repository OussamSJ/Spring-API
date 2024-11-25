package com.iscod.ludotheque.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscod.ludotheque.controllers.dao.EmployeRepository;
import com.iscod.ludotheque.exceptions.EntityDontExistException;
import com.iscod.ludotheque.models.Employe;
import com.iscod.ludotheque.models.Entreprise;
import com.iscod.ludotheque.models.Jeu;
import com.iscod.ludotheque.service.EmployeService;
import com.iscod.ludotheque.service.EntrepriseService;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private EntrepriseService entrepriseService;
	
	


	
	
	public int create(int id_entreprise, Employe employe) {
		
		
		//Récupération de l'entreprise
				Entreprise entreprise = entrepriseService.findById(id_entreprise);
				
				
				
				//Ajouter l'entreprise au jeu
				employe.setEntreprise(entreprise);
				
				
				
				//Mise à jour de la liste des jeux de l'entreprise
				
				entreprise.getEmployes().add(employe);
				
				
				//Sauvegarde du jeu en base
				return employeRepository.save(employe).getId();
	}






	@Override
	public Set<Employe> findAllByEntreprise(int id_entreprise) {
		
		return entrepriseService.findById(id_entreprise).getEmployes();
	}






	@Override
	public Employe findById(int id_employe) {
		
       Optional<Employe> employe = employeRepository.findById(id_employe);
		
		//Si je trouve le jeu
		if(employe.isPresent()) {
			return employe.get();
		}
		
		throw new EntityDontExistException();
	}



	@Override
	public void update(int id_employe, Employe employe) {
		employe.setId(id_employe);

		employeRepository.save(employe);
		
	}






	@Override
	public void updatePartial(Employe employeExistant, Employe newEmploye) {
		
	//  Mettre à jour les champs modifiables
			if(newEmploye.getName() != null) {	
				employeExistant.setName(newEmploye.getName());
			}
			
			if(newEmploye.getPrenom() != null) {	
				employeExistant.setPrenom(newEmploye.getPrenom());
			}
			if(newEmploye.getAge() != 0) {	
				employeExistant.setAge(newEmploye.getAge());
			}
			
			if(newEmploye.getRole() != null) {	
				employeExistant.setRole(newEmploye.getRole());
			}
			
			if(newEmploye.getSalaire() != 0 ) {	
				employeExistant.setSalaire(newEmploye.getSalaire());
			}
			
			if(newEmploye.getDateEnregistrement() != null) {	
				employeExistant.setDateEnregistrement(newEmploye.getDateEnregistrement());
			}
			
			if(newEmploye.getDateNaissance() != null) {	
				employeExistant.setDateNaissance(newEmploye.getDateNaissance());
			}
			
			
			//Mettre à jour lr jru existant dans la base
			employeRepository.save(employeExistant);
		
	}






	
	@Override
	public void delete(Employe employe) {
		  
		employe.getEntreprise().getEmployes().remove(employe);
		employeRepository.delete(employe);
		
	}




		
		

}

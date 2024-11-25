package com.iscod.ludotheque.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscod.ludotheque.controllers.dao.JeuRepository;
import com.iscod.ludotheque.exceptions.EntityDontExistException;
import com.iscod.ludotheque.models.Entreprise;
import com.iscod.ludotheque.models.Jeu;
import com.iscod.ludotheque.service.EntrepriseService;
import com.iscod.ludotheque.service.JeuService;

@Service
public class JeuServiceImpl implements JeuService {

	@Autowired
	private JeuRepository jeuRepository;
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@Override
	public Set<Jeu> findAllByEntreprise(int id_entreprise) {

		return entrepriseService.findById(id_entreprise).getJeux();
		
	}

	@Override
	public Jeu findById(int id_jeu) {
		
		Optional<Jeu> jeu = jeuRepository.findById(id_jeu);
		
		//Si je trouve le jeu
		if(jeu.isPresent()) {
			return jeu.get();
		}
		
		throw new EntityDontExistException();
	}



	@Override
	public int create(int id_entreprise, Jeu jeu) {
	
		//Récupération de l'entreprise
		Entreprise entreprise = entrepriseService.findById(id_entreprise);
		
		
		
		//Ajouter l'entreprise au jeu
		jeu.setEntreprise(entreprise);
		
		
		
		//Mise à jour de la liste des jeux de l'entreprise
		
		entreprise.getJeux().add(jeu);
		
		
		//Sauvegarde du jeu en base
		return jeuRepository.save(jeu).getId();
		
	}

	@Override
	public void update(int id_jeu, Jeu jeu) {
		
		jeu.setId(id_jeu);

		jeuRepository.save(jeu);
	}

	@Override
	public void updatePartial(Jeu jeuExistant, Jeu newJeu) {
		
		//  Mettre à jour les champs modifiables
		if(newJeu.getNom() != null) {	
			jeuExistant.setNom(newJeu.getNom());
		}
		
		if(newJeu.getAgeMini() != 0) {	
			jeuExistant.setAgeMini(newJeu.getAgeMini());
		}
		
		if(newJeu.getDateSortie() != null) {	
			jeuExistant.setDateSortie(newJeu.getDateSortie());
		}
		
		
		//Mettre à jour lr jru existant dans la base
		jeuRepository.save(jeuExistant);
		
	}

	@Override
	public void delete(Jeu jeu) {
		
	
		jeu.getEntreprise().getJeux().remove(jeu);
		jeuRepository.delete(jeu);
	}

	//@Override
	//public void delete(int id_entreprise, int id_jeu) {
	
		//Entreprise entreprise = entrepriseService.findById(id_entreprise);
		//Optional<Jeu> jeu = jeuRepository.findById(id_jeu);
		//entreprise.getJeux().remove(jeu);
	
	//}
	
	
	
	

}

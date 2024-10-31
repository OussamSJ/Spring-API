package com.iscod.ludotheque.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscod.ludotheque.controllers.dao.EntrepriseRepository;
import com.iscod.ludotheque.exceptions.EntityDontExistException;
import com.iscod.ludotheque.models.Entreprise;
import com.iscod.ludotheque.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
@Override
public List<Entreprise> findAll(){
	
		List<Entreprise> entreprises = new ArrayList<Entreprise>();
		
		entrepriseRepository.findAll().forEach(entreprises::add);
		
		return entreprises;
	}

@Override
public Entreprise findById(int id) {
    
	Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
	
	if (entreprise.isPresent()) {
	    return entreprise.get();
	    
    }
	throw new EntityDontExistException();
  }

@Override
public int create(Entreprise entreprise) {
	
	return entrepriseRepository.save(entreprise).getId();
}

}

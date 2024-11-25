package com.iscod.ludotheque.service;

import java.util.Set;

import com.iscod.ludotheque.models.Jeu;

public interface JeuService {

	Set<Jeu> findAllByEntreprise(int id_entreprise);

	Jeu findById(int id_jeu);

	int create(int id_entreprise, Jeu jeu);

	void update(int id_jeu, Jeu jeu);

	void updatePartial(Jeu jeuExistant, Jeu newJeu);

	void delete(Jeu jeu);

	//void delete(int id_entreprise, int id_jeu);
	

}

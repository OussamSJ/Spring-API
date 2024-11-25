package com.iscod.ludotheque.service;

import java.util.Set;

import com.iscod.ludotheque.models.Employe;

public interface EmployeService {
	


	int create(int id_entreprise, Employe employe);

	Set<Employe> findAllByEntreprise(int id_entreprise);

	public Employe findById(int id_employe);

	void update(int id_employe, Employe employe);

	void updatePartial(Employe employeExistant, Employe newEmploye);

	void delete(Employe employe);

	



}

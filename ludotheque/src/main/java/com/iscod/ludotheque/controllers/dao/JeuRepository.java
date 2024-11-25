package com.iscod.ludotheque.controllers.dao;

import org.springframework.data.repository.CrudRepository;
import com.iscod.ludotheque.models.Entreprise;
import com.iscod.ludotheque.models.Jeu;

public interface JeuRepository extends CrudRepository<Jeu,Integer> {
}

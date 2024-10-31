package com.iscod.ludotheque.controllers.dao;

import org.springframework.data.repository.CrudRepository;
import com.iscod.ludotheque.models.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise,Integer> {
}

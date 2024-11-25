package com.iscod.ludotheque.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String ville;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Jeu> jeux = new HashSet<Jeu>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employe> employes = new HashSet<Employe>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Set<Jeu> getJeux() {
		return jeux;
	}
	public void setJeux(Set<Jeu> jeux) {
		this.jeux = jeux;
	}
	
	public Set<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}
	
}

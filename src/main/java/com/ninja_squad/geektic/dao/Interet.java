package com.ninja_squad.geektic.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(sequenceName = "interet_seq", name="interet_seq", initialValue=1, allocationSize=100)
@Table(name="interet")
public class Interet {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "interet_seq")
	private Long id;
	
	@ManyToMany(mappedBy = "interets") 
	private Set<Geek> geeks;
	
	private String nom;

	public Interet(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Geek> getGeek() {
		return geeks;
	}

	public void addGeek(Geek geek) {
		this.geeks.add(geek);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	} 
	
}

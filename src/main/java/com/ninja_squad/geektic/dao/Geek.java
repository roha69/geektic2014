package com.ninja_squad.geektic.dao;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(sequenceName = "geek_seq", name="geek_seq", initialValue=1, allocationSize=100)
@Table(name="geek")
public class Geek {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "geek_seq")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	public EnumGenre genre;
	
	public String nom;
	
	public String prenom;
	
	public int age;
	
	public String mail;
	
	
	@ManyToMany 
	@JoinTable(name = "GEEK_INTERET", 
	           joinColumns = @JoinColumn(name = "ID_GEEK"),
	           inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
	public List<Interet> interets;
	
	@Transient
	public String gravatar;

	public Geek(){}
	
	public Geek(EnumGenre genre, String nom, String prenom, int age,
			String mail, List<Interet> interets) {
		
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
		this.interets = interets;
	}

	public EnumGenre getGenre() {
		return genre;
	}
	
	public void setGenre(EnumGenre genre) {
		this.genre = genre;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public List<Interet> getInterets() {
		return interets;
	}
	
	public void setInterets(List<Interet> interets) {
		this.interets = interets;
	}
	
	public String getGravatar() {
		return gravatar;
	}
	
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
	
}

package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.dao.Interet;

@Repository
public class InteretDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public InteretDAO() {}
	
	/**
	 * Retourne le interet identifiée par l’ID donné
	 * @param id
	 * @return Geek 
	 */
	public Interet findById(Long id){
		return entityManager.find(Interet.class, id);
	}
	
	/**
	 * Retourne tous les interets
	 * @return List<Geek>
	 */
	public List<Interet> findAll(){
		TypedQuery<Interet> query = entityManager.createQuery("SELECT r FROM Interet r", Interet.class);
	    return query.getResultList();
	}	
	
}

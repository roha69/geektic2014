package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class GeekDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public GeekDAO() {}
	
	/**
	 * Retourne le geek identifiée par l’ID donné
	 * @param id
	 * @return Geek 
	 */
	public Geek findById(Long id){
		return entityManager.find(Geek.class, id);
	}
	
	/**
	 * Retourne tous les geeks
	 * @return List<Geek>
	 */
	public List<Geek> findAll(){
		TypedQuery<Geek> query = entityManager.createQuery("SELECT r FROM Geek r", Geek.class);
	    return query.getResultList();
	}
	
}

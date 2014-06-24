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
		
	/**
	 * Retourne selon les critères genre et intérets 
	 * @return List<Geek>
	 */
	public List<Geek> findByCriteria(EnumGenre genre, List<Interet> interets){
		TypedQuery<Geek> query = entityManager.createQuery("select g.nom geek, a.id_interet id_interet from Geek g, geek_interet a where a.id_geek = g.id and a.id_interet in :id_interet and g.genre = :genre;", Geek.class);
		query.setParameter("id_interet", interets);
		query.setParameter("genre", genre.toString());
		return query.getResultList();
		
	}
	
	
}

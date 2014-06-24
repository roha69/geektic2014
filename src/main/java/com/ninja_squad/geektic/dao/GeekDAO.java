package com.ninja_squad.geektic.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		TypedQuery<Geek> query = entityManager.createQuery("SELECT distinct g FROM Geek g left join fetch g.interets", Geek.class);
	    return query.getResultList();
	}
		
	/**
	 * Retourne liste geek selon les critères genre et intérets 
	 * @return List<Geek>
	 */
	public List<Geek> findByCriteria(EnumGenre genre, List<Long> interets){
		TypedQuery<Geek> query = entityManager.createQuery("SELECT distinct g FROM Geek g left join fetch g.interets inner join g.interets ir where ir.id in :list_interet and g.genre = :genre", Geek.class);
		query.setParameter("list_interet", interets);
		query.setParameter("genre", genre);
		return query.getResultList();
		
	}
	
	
}

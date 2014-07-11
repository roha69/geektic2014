package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.Geek;
import com.ninja_squad.geektic.EnumGenre;

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
		TypedQuery<Geek> query = entityManager.createQuery("SELECT distinct g FROM Geek g left join fetch g.interets where g.id = :id", Geek.class);
		query.setParameter("id", id);
		return query.getResultList().get(0);
		//return entityManager.find(Geek.class, id);
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
	
	/**
	 * Retourne le nombre geeks
	 * @return int
	 */
	public int count(){
		Query query = entityManager.createQuery("SELECT count(g.id) FROM Geek g");
		Long count = (Long) query.getSingleResult();
	    return (int) count.longValue();
	}

	/**
	 * Ajoute 1 au nombre de vue du geek
	 * @param id
	 */
	public void increaseView(Long id) {
		Query query = entityManager.createQuery("UPDATE Geek set vues = vues +1 where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();		
	}
		
}

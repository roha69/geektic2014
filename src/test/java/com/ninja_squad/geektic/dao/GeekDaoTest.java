package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.EnumGenre;
import com.ninja_squad.geektic.Geek;

/**
 * DAO Test GEEK
 * @author roha
 */
@SuppressWarnings("unused")
public class GeekDaoTest extends BaseDaoTest {

	public static final Operation STANDARD_OPERATION = 
			Operations.sequenceOf(
					Operations.deleteAllFrom("geek", "interet"),
					Operations.insertInto("geek")
					          .columns("id", "genre", "nom", "prenom", "age", "mail")
					          .values(1L, EnumGenre.HOMME, "HALTER", "Romain",22,"romainhalter@gmx.fr")
							  .values(2L, EnumGenre.FEMME, "CAMILLE", "Elodie",21,"ecamille@gmail.com")
					          .build(),
					Operations.insertInto("interet")
					          .columns("id", "nom")
					          .values(1L, "C")
							  .values(2L, "java")
							  .values(3L, "JS")
							  .values(4L, "HTML")
					          .build(),
				Operations.insertInto("geek_interet")
					          .columns("id_geek", "id_interet")
					          .values(1L, 1L)
							  .values(1L, 2L)
							  .values(2L, 1L)
							  .values(2L, 3L)
							  .values(2L, 4L)
					          .build());
	@Autowired
	private GeekDAO dao;

	@Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(STANDARD_OPERATION); 
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void testFindAll() {
    	List<Geek> geeks = dao.findAll();
    	assertEquals("HALTER",geeks.get(0).getNom());
    	assertEquals("CAMILLE",geeks.get(1).getNom());
    }
    
    @Test
    public void testFindId(){
    	Geek geek = dao.findById(1L);
    	assertEquals("Romain", geek.getPrenom());
    }
    
    @Test
    public void testFindByCriteria(){
   	
    	List<Long> interets = Arrays.asList(1L, 2L);

    	List<Geek> geeks = dao.findByCriteria(EnumGenre.HOMME, interets);
    	assertEquals("HALTER",geeks.get(0).getNom());
    }
    
}

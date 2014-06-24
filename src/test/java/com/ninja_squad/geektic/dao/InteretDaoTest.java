package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

/**
 * DAO Test GEEK
 * @author roha
 */
public class InteretDaoTest extends BaseDaoTest {

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
							  .values(2L, "Java")
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
	private InteretDAO dao;

	@Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(STANDARD_OPERATION); 
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void testFindAll() {
    	List<Interet> Interets = dao.findAll();
    	assertEquals("C",Interets.get(0).getNom());
    	assertEquals("Java",Interets.get(1).getNom());
    	assertEquals("JS",Interets.get(2).getNom());
    	assertEquals("HTML",Interets.get(3).getNom());
    }
    
    @Test
    public void testFindId(){
    	Interet Interet = dao.findById(2L);
    	assertEquals("Java", Interet.getNom());
    }
    
}

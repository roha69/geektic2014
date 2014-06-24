package com.ninja_squad.geektic.dao;

import com.ninja_squad.geektic.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DAO Test GEEK
 * @author roha
 */
public class GeekDaoTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
    // @Autowired
    // private ExampleDao exampleDao;

	public static final Operation STANDARD_OPERATION = 
			Operations.sequenceOf(
					Operations.deleteAllFrom("geek", "interet"),
					Operations.insertInto("geek")
					          .columns("id", "genre", "nom", "prenom", "age", "mail")
					          .values(1L, EnumGenre.HOMME, "HALTER", "Romain",22,"romainhalter@gmx.fr")
							  .values(2L, EnumGenre.FEMME, "CAMILLE", "Elodie",21,"ecamille@gmail.com")
					          .build(),
					Operations.insertInto("interet")
					          .columns("id", "id_geek", "nom")
					          .values(1L, 1L, "C")
							  .values(2L, 1L, "java")
							  .values(3L, 1L, "JS")
							  .values(4L, 2L, "HTML")
					          .build());
	@Autowired
	private GeekDAO dao;

    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(STANDARD_OPERATION); 
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
	
	@Before
	public void setUp() throws Exception {
		populateDatabase();
		em.getTransaction().begin();
	}

    @Test
    public void testSomeDaoMethod() {
        // implement your test here, by calling the exampleDao method to test.
    }
    
}

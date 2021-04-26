package edu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("Ass").createEntityManager();
	}
	
	
}

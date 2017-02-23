package fr.adaming.testRobin;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Categorie;

import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

public class ClassTest {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Categorie c1 = new Categorie("Outils","De magnifiques outils de jardin");
		Categorie c2 = new Categorie("Jouets","Pour occuper les gosses");
		Categorie c3 = new Categorie("Armes","pour s'en débarrasser");
		
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		tx.commit();
		
		tx.begin();
		IClientService clientService = new ClientServiceImpl();
		List<Categorie> liste = clientService.getAllCategorieService();
		
		for(Categorie c:liste){
			System.out.println(c);
		}
		
		

	}

}

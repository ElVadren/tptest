package fr.adaming.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;

@Stateless
public class ClientDaoImpl implements IClientDao {

	//appel de l'entity manager pour la connexion avec la bdd.
	@PersistenceContext(unitName="PU")
	EntityManager em;
	
	
	//la m�thode pour obtenir la liste des cat�gories
	@Override
	public List<Categorie> getAllCategorie() {
		
		//�criture de la requ�te :
		String req = "select c from Categorie c";
		Query query = em.createQuery(req);
		//r�cup�ration de la liste
		List<Categorie> listeCategorie = query.getResultList();
		//condition pour v�rifier si la liste n'est pas vide :
		if(listeCategorie.size()!=0){
			return listeCategorie;
		}else{
		System.out.println("la liste est vide");
		return null;
		}
	}

}

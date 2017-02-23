package fr.adaming.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless
public class ClientDaoImpl implements IClientDao {

	//appel de l'entity manager pour la connexion avec la bdd.
	@PersistenceContext(unitName="PU")
	EntityManager em;
	
	
	//la méthode pour obtenir la liste des catégories
	@Override
	public List<Categorie> getAllCategorie() {
		
		//écriture de la requête :
		String req = "select c from Categorie c";
		Query query = em.createQuery(req);
		//récupération de la liste
		List<Categorie> listeCategorie = query.getResultList();
		//condition pour vérifier si la liste n'est pas vide :
		if(listeCategorie.size()!=0){
			return listeCategorie;
		}else{
		System.out.println("la liste est vide");
		return null;
		}
	}

	/**
	 * La méthode pour obtenir la liste des produits par catégorie :
	 */
	@Override
	public List<Produit> getProduitsByCategorie(Categorie categorie) {
	
	
	
		/**
		 * écriture de la requête
		 */
		String req = "select p from Produit p where p.categorie.idCategorie=:idCategorie";
		/**
		 * Insertion dans une query et remplacement du pseudo par l'id de la catégorie choisie
		 */
		Query query = em.createQuery(req);
		query.setParameter("idCategorie", categorie.getIdCategorie());
		/**
		 * Récupération des résultats dans une liste et transmission
		 */
		List<Produit> listeProduitCat = query.getResultList();
		if(listeProduitCat.size()!=0){
		return listeProduitCat;
		}else{
		return null;
		}
	}

	/**
	 * La methode pour obtenir une liste de produit via un mot clé 
	 * Version 1 : recherche uniquement dans la designation !!
	 * 
	 * 
	 */
	@Override
	public List<Produit> getProduitsByMot(String saisie) {
		//instanciation d'articles pour la recherche
		Produit p1 = new Produit ("Rateau","Un joli rateau",15);
		Produit p2 = new Produit ("Pistolet","un petit pistolet",15);
		Produit p3 = new Produit ("Pioche","Une jolie pioche",5);
		Produit p4 = new Produit ("Rapeur","un gros naze",25);
		Produit p5 = new Produit ("Quiche","pas très bonne",15);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		
		String req = "select p from Produit p where p.designation like '%"+saisie+"%'";
		Query query = em.createQuery(req);
		List<Produit> listeProduitKey = query.getResultList();
		if(listeProduitKey.size()!=0){
			return listeProduitKey;
			}else{
			return null;
	}

}
}
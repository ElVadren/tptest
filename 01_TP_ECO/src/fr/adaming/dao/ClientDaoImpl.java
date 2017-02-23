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
		
		
		String req = "select p from Produit p where p.designation like '%"+saisie+"%'";
		Query query = em.createQuery(req);
		List<Produit> listeProduitKey = query.getResultList();
		if(listeProduitKey.size()!=0){
			return listeProduitKey;
			}else{
			return null;
	}

}


//methodeeeeeee a supprimer après
	@Override
	public void remplirbdd() {
		Produit p1 = new Produit ("Rateau","Un joli rateau",15);
		Produit p2 = new Produit ("Pioche","une belle pioche verte",30);
		Produit p3 = new Produit ("Pelle","Une pelle en mauvais état",5);
		Produit p4 = new Produit ("Legos Harry Potter","des legos chers et inutiles",125);
		Produit p5 = new Produit ("Legos Star wars","des legos encore plus cher",1250);
		Produit p6 = new Produit ("Quiche","Une délicieuse quiche à la viande de cheval",15);
		Produit p7 = new Produit ("Pizza","une pizza au chèvre, beurk",5);
		Produit p8 = new Produit ("Hamburger","la base",5);
		Produit p9 = new Produit ("Pistolet","toujours utile",250);
		Produit p10 = new Produit ("Couteau","pratique",32);
		
		Categorie c1 = new Categorie ("Outils","ça peut servir");
		Categorie c2 = new Categorie ("Lego","dangeureux et chiants");
		Categorie c3 = new Categorie ("Bouffe","vital");
		Categorie c4 = new Categorie ("Armes","juste au cas où");
		
		p1.setCategorie(c1);
		p2.setCategorie(c1);
		p3.setCategorie(c1);
		p4.setCategorie(c2);
		p5.setCategorie(c2);
		p6.setCategorie(c3);
		p7.setCategorie(c3);
		p8.setCategorie(c4);
		p9.setCategorie(c4);
		p10.setCategorie(c4);
		
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		em.persist(p7);
		em.persist(p8);
		em.persist(p9);
		em.persist(p10);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
	}
}
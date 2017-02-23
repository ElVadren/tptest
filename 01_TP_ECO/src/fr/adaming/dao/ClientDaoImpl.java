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

	/**
	 * La m�thode pour obtenir la liste des produits par cat�gorie :
	 */
	@Override
	public List<Produit> getProduitsByCategorie(Categorie categorie) {
		System.out.println("LEURRREUR NIQUE TA MAMAMMM");
		Produit p1 = new Produit ("Rateau","Un joli rateau",15);
		em.persist(p1);
		System.out.println(p1);
		/**
		 * �criture de la requ�te
		 */
		String req = "select p from Produit p where p.categorie.idCategorie=:idCategorie";
		/**
		 * Insertion dans une query et remplacement du pseudo par l'id de la cat�gorie choisie
		 */
		Query query = em.createQuery(req);
		query.setParameter("idCategorie", categorie.getIdCategorie());
		/**
		 * R�cup�ration des r�sultats dans une liste et transmission
		 */
		List<Produit> listeProduitCat = query.getResultList();
		if(listeProduitCat.size()!=0){
		return listeProduitCat;
		}else{
		return null;
		}
	}

}

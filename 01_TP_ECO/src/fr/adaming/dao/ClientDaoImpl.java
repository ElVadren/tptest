package fr.adaming.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

@Stateless
public class ClientDaoImpl implements IClientDao {

/**
 * appel de l'entity manager pour la connexion avec la bdd.
 */
	@PersistenceContext(unitName="PU")
	EntityManager em;
	
	
	/**
	 * la m�thode pour obtenir la liste des cat�gories
	 */
	@Override
	public List<Categorie> getAllCategorie() {
		
		/**
		 * �criture de la requ�te :
		 */
		String req = "select c from Categorie c";
		Query query = em.createQuery(req);
		/**
		 * r�cup�ration de la liste
		 */
		List<Categorie> listeCategorie = query.getResultList();
		/**
		 * condition pour v�rifier si la liste n'est pas vide :
		 */
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

	/**
	 * La methode pour obtenir une liste de produit via un mot cl� 
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
	
	/**
	 * m�thode pour obtenir un produit via son id
	 */
	@Override
	public Produit getProduitById(long id) {
		String req = "select p from Produit p where p.idProduit=:idPseudo";
		Query query = em.createQuery(req);
		query.setParameter("idPseudo", id);
		Produit produit = (Produit) query.getSingleResult();
		if (produit!=null){
			return produit;
		}else{
		return null;
		}
	}

	/**
	 * methode pour enregistrer un nouveau client dans la bdd
	 */
	@Override
	public void enregistrementClient(Client client) {
		em.persist(client);	
	}

	/**
	 * La m�thode d�bute par la cr�ation d'une nouvelle commande :
	 * On lui attribut le client ainsi que la date
	 * Il faut ensuite enregistrer la commande dans la base de donn�e.
	 * Par persistence, toutes les informations (panier/ligne de commande) sont enregistr�e et li�e en m�me temps
	 */
	@Override
	public void enregistrementCommande(Client client, List<Produit> listeProduit) {
		Commande commande = new Commande ();
		commande.setClient(client);
		Panier panier = new Panier ();
		List<LigneCommande> listeC = new ArrayList<LigneCommande>();
		for (Produit p:listeProduit){
			LigneCommande produitc = new LigneCommande();
			produitc.setDesignation(p.getDesignation());
			produitc.setDescription(p.getDescription());
			produitc.setQuantite(p.getQuantite());
			produitc.setPrix(p.getPrix());
			produitc.setPanier(panier);
			listeC.add(produitc);
		}
		panier.setListProduit(listeC);
	
		Date date = new Date();
		System.out.println(date);
		commande.setDateCommande(date);
		commande.setPanier(panier);
	
		em.persist(commande);
	}
	

	/**
	 * Cette m�thode permet de r�cup�rer la liste de tout les produits pour l'afficher sur la page d'accueil
	 */
	@Override
	public List<Produit> getAllProduits() {
		/**
		 * �criture de la requ�te :
		 */
		String req = "select p from Produit p";
		Query query = em.createQuery(req);
		/**
		 * r�cup�ration de la liste
		 */
		List<Produit> listeProduit = query.getResultList();
		/**
		 * condition pour v�rifier si la liste n'est pas vide :
		 */
		if(listeProduit.size()!=0){
			return listeProduit;
		}else{
		return null;
		}
	}

	/**
	 * Cette m�thode est utilis�e pour reconnaitre un ancien client d'un nouveau client � l'aide ses identifiantss
	 */
	@Override
	public Client isExist(Client client) {
		/**
		 * 	requ�te �crite via jpql 
		 */

		String reqSql = "SELECT c FROM Client c WHERE c.nomClient=:pNom and c.email=:pMail";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("pNom", client.getNomClient());
		reqQuery.setParameter("pMail", client.getEmail());

		try{
			Client clientr = (Client) reqQuery.getSingleResult();
			
			if (clientr!=null) {
				return clientr;
			} else {
				return null;
			}
		}catch(NoResultException e){
			return null;
		}
		
		
	}

	/**
	 * Cette m�thode permet de r�cup�rer toutes commandes d'un client, pour que celui-ci puisse les consulter 
	 * dans son espace personnel
	 */
	@Override
	public List<Commande> getCommandeByClient(Client client) {
		/**
		 * �criture de la requ�te
		 */
		String req = "select c from Commande c where c.client.idClient=:idClient";
		/**
		 * Insertion dans une query et remplacement du pseudo par l'id de la cat�gorie choisie
		 */
		Query query = em.createQuery(req);
		query.setParameter("idClient", client.getIdClient());
		/**
		 * R�cup�ration des r�sultats dans une liste et transmission
		 */
		List<Commande> listeCommande = query.getResultList();
		if(listeCommande.size()!=0){
		return listeCommande;
		}else{
		return null;
		}
	}

	/**
	 * Cette m�thode permet � un client connect� de consulter les anciens panier qu'il a command� 
	 */
	public List<LigneCommande> getPanierByCommande(Commande commande) {
		/**
		 * Ecriture de la requ�te : tous les produits command�s correspondant au panier 
		 * de la commande sont extraits de la base.
		 * Comme � chaque panier correspond une commande dans la bdd et que une commande et un panier sont cr�er 
		 * en m�me temps, l'ID du panier = ID de la commande.
		 * 
		 */
		String req = "select l from LigneCommande l where l.panier.id=:idPanier";
		Query query = em.createQuery(req);
		query.setParameter("idPanier", commande.getIdCommande());
		List<LigneCommande> listeProduitCo = query.getResultList();
		if (listeProduitCo.size()>0){
		return listeProduitCo;
		}else{
			return null;
		}
	}

	

	


	
}
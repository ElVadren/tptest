/**
 * Interface DAO pour les méthodes du clients :
 * - consulter ttes les catégories 
 * - récupérer tt les produits d'une catégorie
 * - rechercher produit par mot clé 
 */

package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;

@Local
public interface IClientDao {

	/**
	 * afficher la liste des catégories
	 */
	public List<Categorie> getAllCategorie();

	/**
	 * afficher des produits par catégorie
	 */
	public List<Produit> getProduitsByCategorie(Categorie categorie);

	/**
	 * la methode pour rechercher des produits selon un mots clés :
	 */
	public List<Produit> getProduitsByMot(String saisie);
	
	/**
	 * méthode pour récupérer l'intégralité d'un produit par son id :
	 */
	public Produit getProduitById (long id);
	
	/**
	 * methode pour enregistrement d'un client
	 */
	public void enregistrementClient (Client client);
	
	
	public void enregistrementCommande (Client client, List<Produit> listeProduit);
	
	/**
	 * methode pour récupérer tous les produits :
	 */
	public List<Produit> getAllProduits();
	

	/**
	 * methode pour vérifier si le client existe :
	 */
	public Client isExist(Client client);
	
	/**
	 * methode pour récupérer toutes les commandes d'un client :
	 */
	public List<Commande> getCommandeByClient (Client client);
}

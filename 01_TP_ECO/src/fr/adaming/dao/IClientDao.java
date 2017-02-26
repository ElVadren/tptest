/**
 * Interface DAO pour les m�thodes du clients :
 * - consulter ttes les cat�gories 
 * - r�cup�rer tt les produits d'une cat�gorie
 * - rechercher produit par mot cl� 
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
	 * afficher la liste des cat�gories
	 */
	public List<Categorie> getAllCategorie();

	/**
	 * afficher des produits par cat�gorie
	 */
	public List<Produit> getProduitsByCategorie(Categorie categorie);

	/**
	 * la methode pour rechercher des produits selon un mots cl�s :
	 */
	public List<Produit> getProduitsByMot(String saisie);
	
	/**
	 * m�thode pour r�cup�rer l'int�gralit� d'un produit par son id :
	 */
	public Produit getProduitById (long id);
	
	/**
	 * methode pour enregistrement d'un client
	 */
	public void enregistrementClient (Client client);
	
	
	public void enregistrementCommande (Client client, List<Produit> listeProduit);
	
	/**
	 * methode pour r�cup�rer tous les produits :
	 */
	public List<Produit> getAllProduits();
	

	/**
	 * methode pour v�rifier si le client existe :
	 */
	public Client isExist(Client client);
	
	/**
	 * methode pour r�cup�rer toutes les commandes d'un client :
	 */
	public List<Commande> getCommandeByClient (Client client);
}

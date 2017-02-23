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
import fr.adaming.entities.Produit;

@Local
public interface IClientDao {
	
	//la m�thode pour r�cup�rer la liste des cat�gories
	public List<Categorie> getAllCategorie ();
	
	//la m�thode pour afficher les produits par cat�gories 
	public List<Produit> getProduitsByCategorie (Categorie categorie);
	

}

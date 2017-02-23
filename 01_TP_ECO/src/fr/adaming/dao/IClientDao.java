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

@Local
public interface IClientDao {
	
	//la méthode pour récupérer la liste des catégories
	public List<Categorie> getAllCategorie ();
	
	

}

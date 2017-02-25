package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IAdminService {

	Admin admin = new Admin();
	Produit produit = new Produit();
	
/**
 * Méthode d'authentification d'un administrateur
 * @param ad
 * @return
 */
	public Admin isExistAdminService(Admin ad);
	
	/**méthode d'ajout de produit par l'admin à la base de données
	 * 
	 * @param p
	 * @return
	 */
	
	public Produit ajoutProduitService(Produit p);
	
	public Produit supprimerProduitService(long id);
	
	public Produit modifierProduitService(long id, String description, String designation, double prix);

	public Produit rechercherProduitParIdService(long id);
	
	public List<Produit> getAllProduitService();
	
	public Categorie ajoutCategorieService(Categorie c);
	
	
}

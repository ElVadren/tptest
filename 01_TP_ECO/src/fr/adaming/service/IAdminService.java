package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IAdminService {

	Admin admin = new Admin();
	Produit produit = new Produit();
	
/**
 * M�thode d'authentification d'un administrateur
 * @param ad
 * @return
 */
	public Admin isExistAdminService(Admin ad);
	
	
	/**
	 * M�thodes de gestion des produits
	 */
	
	/**m�thode d'ajout de produit par l'admin � la base de donn�es
	 * 
	 * @param p
	 * @return
	 */
	
	public Produit ajoutProduitService(Produit p);
	
	public Produit supprimerProduitService(long id);
	
	public Produit modifierProduitService(long id, String description, String designation, double prix);

	public Produit rechercherProduitParIdService(long id);
	
	public List<Produit> getAllProduitService();
	
	
	/**
	 * M�thode de gestion des cat�gories
	 * 	@param c
	 * @return
	 */
	
	public Categorie ajoutCategorieService(Categorie c);

	public Categorie suppressionCategorieService(long idCategorie);


	public Categorie modifierCategorieService(long idCategorie, String description, String nomCategorie);


	public List<Categorie> getAllCategorieService();


	public Categorie rechercherCategorieParIdService(long idCategorie);


	public void attribuerService(long idProduit, long idCategorie);
	
	
	
}

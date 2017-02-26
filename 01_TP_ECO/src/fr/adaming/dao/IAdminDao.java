package fr.adaming.dao;


import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IAdminDao {

/**
 * 	Méthodes de la Dao d'authentification et de gestion des produits et des catégories
 * @param ad
 * @return
 */
	
	/**
	 * authentification
	 */
	public Admin isExistAdminDao(Admin ad);
	
	/**
	 * gestion des produits
	 * @param p
	 * @return
	 */
	
	public Produit ajoutProduitDao(Produit p);
	
	public Produit supprimerProduitDao(long id);
	
	public Produit modifierProduitDao(long id, String description, String designation, double prix);

	public Produit rechercherProduitParIdDao(long id);

	public List<Produit> getAllProduitDao();
	
	/**
	 * gestion des catégories
	 * @param c
	 * @return
	 */

	public Categorie ajoutCategorieDao(Categorie c);

	public Categorie supprimerCategorieDao(long idCategorie);

	public Categorie modifierCategorieDao(long idCategorie, String description, String nomCategorie);

	public List<Categorie> getAllCategorieDao();

	public Categorie rechercherCategorieParIdDao(long idCategorie);
	
	/**
	 * atribuer un produit à une catégorie
	 * @param idProduit
	 * @param idCategorie
	 * @return
	 */

	public Object attribuerDao(long idProduit, long idCategorie);

}

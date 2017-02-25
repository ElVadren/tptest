package fr.adaming.dao;


import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IAdminDao {

//	Méthode isExist de la Dao
	public Admin isExistAdminDao(Admin ad);
	
	public Produit ajoutProduitDao(Produit p);
	
	public Produit supprimerProduitDao(long id);
	
	public Produit modifierProduitDao(long id, String description, String designation, double prix);

	public Produit rechercherProduitParIdDao(long id);

	public List<Produit> getAllProduitDao();

	public Categorie ajoutCategorieDao(Categorie c);

	public Categorie supprimerCategorieDao(long idCategorie);

	public Categorie modifierCategorieDao(long idCategorie, String description, String nomCategorie);

	public List<Categorie> getAllCategorieDao();

	public Categorie rechercherCategorieParIdDao(long idCategorie);

	public Object attribuerDao(long idProduit, long idCategorie);

}

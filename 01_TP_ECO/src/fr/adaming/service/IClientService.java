package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local
public interface IClientService {

	
	public List<Categorie> getAllCategorieService ();
	public List<Produit> getProduitsByCategorieService (Categorie categorie); 
	public List<Produit> getProduitsByMotService(String saisie);
	
	
	//méthode à supprimer à la fin 
		public void remplirbddService();
	
}

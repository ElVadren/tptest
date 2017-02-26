package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;

@Local
public interface IClientService {

	
	public List<Categorie> getAllCategorieService ();
	public List<Produit> getProduitsByCategorieService (Categorie categorie); 
	public List<Produit> getProduitsByMotService(String saisie);
	public Produit getProduitByIdService (long id);
	public void enregistrementClientService (Client client);
	public void enregistrementCommandeService (Client client, List<Produit> listeProduit);
	public List<Produit> getAllProduitsService();
	public Client isExistService(Client client);
	public List<Commande> getCommandeByClientService (Client client);
}

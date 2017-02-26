package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;

@Stateless
public class ClientServiceImpl implements IClientService {

	@EJB
	IClientDao clientDao;
	
	/**
	 * la méthode pour obtenir la liste des catégories :
	 */
	@Override
	public List<Categorie> getAllCategorieService() {	
		return clientDao.getAllCategorie();
	}

	/**
	 * La methode pour obtenir les produits selon leur catégorie :
	 */
	@Override
	public List<Produit> getProduitsByCategorieService(Categorie categorie) {
		return clientDao.getProduitsByCategorie(categorie);
	}

	/**
	 * la methode pour obtenir les produits selon un mot clés 
	 */
	@Override
	public List<Produit> getProduitsByMotService(String saisie) {
		return clientDao.getProduitsByMot(saisie);
	}


	@Override
	public void enregistrementClientService(Client client) {
		clientDao.enregistrementClient(client);
		
	}

	/**
	 * la methode pour obtenir un produit par son ID
	 */
	@Override
	public Produit getProduitByIdService(long id) {
		return clientDao.getProduitById(id);
	}
	


	@Override
	public void enregistrementCommandeService(Client client, List<Produit> listeProduit) {
		clientDao.enregistrementCommande(client, listeProduit);
	}

	/**
	 * Methode pour obtenir la liste complète des produits
	 */
	@Override
	public List<Produit> getAllProduitsService() {
		return clientDao.getAllProduits();
	}

	/**
	 * Methode pour vérifier l'existence d'un client
	 */
	@Override
	public Client isExistService(Client client) {
		return clientDao.isExist(client);
	}

	/**
	 * Cette methode permet d'obtenir la liste des commandes d'un client
	 */
	@Override
	public List<Commande> getCommandeByClientService(Client client) {
		return clientDao.getCommandeByClient(client);
	}



}

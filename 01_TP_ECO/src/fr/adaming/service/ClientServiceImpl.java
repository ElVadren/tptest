package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
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
	
//methode à supprimer a la fin
	@Override
	public void remplirbddService() {
		clientDao.remplirbdd();
		
	}



}

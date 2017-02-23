package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
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

}

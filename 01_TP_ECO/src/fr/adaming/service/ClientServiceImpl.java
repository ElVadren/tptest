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
	 * la m�thode pour obtenir la liste des cat�gories :
	 */
	@Override
	public List<Categorie> getAllCategorieService() {	
		return clientDao.getAllCategorie();
	}

	/**
	 * La methode pour obtenir les produits selon leur cat�gorie :
	 */
	@Override
	public List<Produit> getProduitsByCategorieService(Categorie categorie) {
		return clientDao.getProduitsByCategorie(categorie);
	}

	/**
	 * la methode pour obtenir les produits selon un mot cl�s 
	 */
	@Override
	public List<Produit> getProduitsByMotService(String saisie) {
		return clientDao.getProduitsByMot(saisie);
	}

	@Override
	public void remplirbddService() {
		clientDao.remplirbdd();
		
	}

}

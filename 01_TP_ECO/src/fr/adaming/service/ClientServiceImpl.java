package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;

@Stateless
public class ClientServiceImpl implements IClientService {

	@EJB
	IClientDao clientDao;
	
	//la m�thode pour chercher la liste des cat�gories
	@Override
	public List<Categorie> getAllCategorieService() {	
		return clientDao.getAllCategorie();
	}

}

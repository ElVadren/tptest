package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;

@Local
public interface IClientService {

	
	public List<Categorie> getAllCategorieService ();
	
}

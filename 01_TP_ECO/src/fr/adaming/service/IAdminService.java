package fr.adaming.service;

import fr.adaming.entities.Admin;

public interface IAdminService {

	Admin admin = new Admin();
	
//	Méthode d'authentification d'un administrateur
	public Admin isExistAdminService(Admin ad);
	
//	public Admin ajoutAdminService(Admin ad);
	
	
}

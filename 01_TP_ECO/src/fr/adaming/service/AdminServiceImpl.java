package fr.adaming.service;

import fr.adaming.dao.AdminDaoImpl;
import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;

public class AdminServiceImpl implements IAdminService {

	IAdminDao adminDao = new AdminDaoImpl();
	
//	impl�mentation de la m�thode isExistAdmin de l'interface IAdminService
	@Override
	public Admin isExistAdminService(Admin ad) {
	return adminDao .isExistAdminDao(ad);
	}

//	
	
	
	

}

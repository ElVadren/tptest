package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import fr.adaming.dao.AdminDaoImpl;
import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless
@Local
public class AdminServiceImpl implements IAdminService {

	/**
	 * injection de dependance
	 */
		@EJB
		IAdminDao adminDao;
		
		
/**
 * 	implémentation de la méthode isExistAdmin de l'interface IAdminService
 */
	@Override
	public Admin isExistAdminService(Admin ad) {
	return adminDao .isExistAdminDao(ad);
	}
	
@Override
public Produit ajoutProduitService(Produit p) {
	return adminDao.ajoutProduitDao(p);
}


@Override
public Produit supprimerProduitService(long id) {
return adminDao.supprimerProduitDao(id);
}
	
@Override
public Produit modifierProduitService(long id, String description, String designation, double prix) {
return adminDao.modifierProduitDao(id, description, designation, prix);
}
	
@Override
public Produit rechercherProduitParIdService(long id) {
return adminDao.rechercherProduitParIdDao(id);
}

@Override
public List<Produit> getAllProduitService() {
	return adminDao.getAllProduitDao();
}

@Override
public Categorie ajoutCategorieService(Categorie c) {
	return adminDao.ajoutCategorieDao(c);
}




}

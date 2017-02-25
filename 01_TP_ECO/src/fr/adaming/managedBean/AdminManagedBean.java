package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;


//Définition jsf du managedBean
@ManagedBean(name="amb")
@ViewScoped
public class AdminManagedBean implements Serializable {

	//pour récupérer les info depuis la vue :
	private Admin admin;
	//faire le lien avec le service, annotation avec EJB pour qu'il soit injecté
	@EJB
	private IAdminService adminService;
	
//	définition des attributs du managedbean de l'admin
	private long id;
	private String nom;
	private String password;
	private long idProduit;
	private List<Produit> listeProduits;
//	affichage par actualisation
	private boolean rendu1=false;
	private boolean rendu2=true;
	
	
/**
 * Lien avec la classe produit, pour les méthodes de gestion des produits
 * @return
 */
	private Produit produit;
	private Categorie categorie;
	
//	get et set



	
	
public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	
	
	
/**Méthode de récupération de l'admin instancié et initialisation d'un admin
 * 
 * @return
 */
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	
	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	



	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	
	
	
public boolean isRendu1() {
		return rendu1;
	}

	public void setRendu1(boolean rendu1) {
		this.rendu1 = rendu1;
	}

	public boolean isRendu2() {
		return rendu2;
	}

	public void setRendu2(boolean rendu2) {
		this.rendu2 = rendu2;
	}

	
	
	
/**
 * constructeurs
 */


	public AdminManagedBean() {
		this.admin = new Admin();
		this.produit=new Produit();
		this.listeProduits = new ArrayList<Produit>();
		this.categorie = new Categorie();
	}

	
	

	/**
	 * 
	 *  méthode d'authentification de l'administrateur
	* appel de la méthode d'authentification définie en interface de l'administrateur IAdminService 
	 */
	public String isExistAdminMb() {
		
		System.out.println("test isExist");
		Admin adminRetour= new Admin();
		adminRetour = adminService.isExistAdminService(this.admin) ;
		
		if (adminRetour != null) {
			System.out.println("ok");
			return "succes";
		} else {
			return "echec";
		}
		
		
	}
		
	/**
	 * méthode d'ajout d'un produit
	 * @return
	 */
	
		public String ajoutProduit() {
			
			System.out.println("test ajoutProduit");
			
			Produit produitRetour = adminService.ajoutProduitService(this.produit);
			 if (produitRetour != null) {
				 return "succes";
			 } else {
				 return "echec";
			 }
		}
		
		
		/**
		 * méthode de suppression d'un produit
		 * @return
		 */
		
		public void suppressionProduit() {
			System.out.println("test suppression");
			adminService.supprimerProduitService(produit.getIdProduit());
			this.rendu1=true;
			this.rendu2=false;
		}
		
		
		/**
		 * méthode de modification d'un produit
		 * @return
		 */
		
		public void modifierProduit() {
			System.out.println("test modifier");
			adminService.modifierProduitService(produit.getIdProduit(), produit.getDescription(), produit.getDesignation(), produit.getPrix());
		}
		
		

		/**
		 * Méthode d'affichage de l'ensemble des produits de la base de données
		 */
		
		public void afficherProduit() {
			System.out.println("test afficher la liste des produits");
			this.listeProduits = adminService.getAllProduitService();
			this.rendu1=false;
			this.rendu2=true;
		}
		
		
		
		
		/**
		 * Méthodes de gestion des catégories
		 */
		
		
		/**
		 * méthode d'ajout d'une catégorie
		 * @return
		 */
		
			public String ajoutCategorie() {
				
				System.out.println("test ajoutCatégorie");
				
				Categorie categorieRetour = adminService.ajoutCategorieService(this.categorie);
				 if (categorieRetour != null) {
					 return "succes";
				 } else {
					 return "echec";
				 }
			}
		
	}



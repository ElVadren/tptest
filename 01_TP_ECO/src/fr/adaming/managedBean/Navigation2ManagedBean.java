/**
 *ManagedBean destine a la navigation client parametre en Session de maniere a pouvoir utiliser
 *des affichages differents
 */

package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;


@ManagedBean
@SessionScoped
public class Navigation2ManagedBean implements Serializable{



/**
 * D�claration des attributs :
 * serialisation
 * rendu permet l'affichage au rafraichissement de la page et appel de la methode via l'attribut rendered
 */
	private static final long serialVersionUID = 1L;
	private Client client;
	private boolean rendu;
	private List<Categorie> listeCategorie;
	private List<Produit> listeProduit;
	private Categorie categorie;
	private Produit produit;



/**
 * Instation pour le lien avec le service :
 */
	@EJB
	IClientService clientService;
	
	@EJB
	IAdminService adminService;
	
/**
 * les constructeurs :	
 */
public Navigation2ManagedBean() {
	this.client = new Client();
	this.produit = new Produit();
	this.categorie = new Categorie();
}

/**
 * D�claration des getters et setters :
 */


	public boolean isRendu() {
		return rendu;
	}

	public List<Categorie> getListeCategorie() {
	return listeCategorie;
}

public void setListeCategorie(List<Categorie> listeCategorie) {
	this.listeCategorie = listeCategorie;
}

	public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}
	
	
public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
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
	

	/**
	 * D�claration des m�thodes :
	 */
	

	/**
	 * m�thode de l'espace utilisateur
	 */
	/**
	 * la methode pour obtenir la liste des cat�gorie
	 */
	public String listeCat(){
		this.listeCategorie = clientService.getAllCategorieService();
		return "affichercategories";
	}

	/**
	 * la m�thode pour obtenir la liste des produits par cat�gorie :
	 * La deuxi�me utilise une m�thode de navigation � partir de la page d'afficage des diff�rentes cat�gories
	 */

	
	public String listeProNav(){
		this.listeProduit = clientService.getProduitsByCategorieService(categorie);
		
		return "afficherproduits";
	}
	
	public String accueil(){	
		this.listeProduit = clientService.getAllProduitsService();
		
		return "index";
	}
	

}

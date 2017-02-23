/**
 * ManagedBean de navigation qui permet l'appel et l'affichage de :
 * - consulter la liste des catégories
 * - consulter la liste des produits selon la catégorie 
 * - rechercher un produit via mot clés 
 */

package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.IClientService;

/** 
 * 
 * Déclaration du ManagedBean en ViewScopped : 
 * Résultat hors session, uniquement à l'affichage de la page pour ces résultats
 *
 */
@ManagedBean
@ViewScoped 
public class NavigationManagedBean implements Serializable{



/**
 * Déclaration des attributs :
 * serialisation
 * rendu permet l'affichage au rafraichissement de la page et appel de la methode via l'attribut rendered
 */
	private static final long serialVersionUID = 1L;
	private Client client;
	private boolean rendu;
	private List<Categorie> listeCategorie;
	private List<Produit> listeProduit;
	private Categorie categorie;
	private String saisie;

/**
 * Instation pour le lien avec le service :
 */
	@EJB
	IClientService clientService;
	
	
/**
 * les constructeurs :	
 */
public NavigationManagedBean() {
	this.client = new Client();
	this.categorie = new Categorie();
}

/**
 * Déclaration des getters et setters :
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
	
	
public String getSaisie() {
		return saisie;
	}

	public void setSaisie(String saisie) {
		this.saisie = saisie;
	}

/**
 * Déclaration des méthodes :
 */
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * la methode pour obtenir la liste des catégorie
	 */
	public void listeCat(){
		this.listeCategorie = clientService.getAllCategorieService();
		this.rendu = true;	
	}

	/**
	 * la méthode pour obtenir la liste des produits par catégorie :
	 */
	public void listePro(){
		this.listeProduit = clientService.getProduitsByCategorieService(categorie);
		this.rendu = true;
	}
	
	/**la methode pour obtenir la liste des produits par mot clés :
	 * 
	 */
	public void listeMot(){
		this.listeProduit = clientService.getProduitsByMotService(saisie);
		this.rendu=true;
	}
	
	
	
//methode a supprimer à la fin :
	public void remplir(){
		clientService.remplirbddService();
	}
	
}

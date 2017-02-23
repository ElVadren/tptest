/**
 * ManagedBean de navigation qui permet l'appel et l'affichage de :
 * - consulter la liste des cat�gories
 * - consulter la liste des produits selon la cat�gorie 
 * - rechercher un produit via mot cl�s 
 */

package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.service.IClientService;

/** 
 * 
 * D�claration du ManagedBean en ViewScopped : 
 * R�sultat hors session, uniquement � l'affichage de la page pour ces r�sultats
 *
 */
@ManagedBean
@ViewScoped 
public class NavigationManagedBean implements Serializable{



/**
 * D�claration des attributs :
 * serialisation
 * rendu permet l'affichage au rafraichissement de la page et appel de la methode via l'attribut rendered
 */
	private static final long serialVersionUID = 1L;
	private Client client;
	private boolean rendu;
	private List<Categorie> listeCategorie;

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
/**
 * D�claration des m�thodes :
 */
	
	public void listeCat(){
		this.listeCategorie = clientService.getAllCategorieService();
		this.rendu = true;	
	}


}

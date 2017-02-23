/**
 * ManagedBean de navigation qui permet l'appel et l'affichage de :
 * - consulter la liste des cat�gories
 * - consulter la liste des produits selon la cat�gorie 
 * - rechercher un produit via mot cl�s 
 */

package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Categorie;
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
	private boolean rendu;

/**
 * Instation pour le lien avec le service :
 */
	IClientService clientService;
/**
 * D�claration des getters et setters :
 */
	public boolean isRendu() {
		return rendu;
	}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}
/**
 * D�claration des m�thodes :
 */
	
	public void getListeCategorie(){
		List<Categorie> listeCategorie = clientService.getAllCategorieService();
		this.rendu = true;	
	}


}

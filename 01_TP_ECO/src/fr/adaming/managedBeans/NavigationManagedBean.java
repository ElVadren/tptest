/**
 * ManagedBean de navigation qui permet l'appel et l'affichage de :
 * - consulter la liste des catégories
 * - consulter la liste des produits selon la catégorie 
 * - rechercher un produit via mot clés 
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
	private boolean rendu;

/**
 * Instation pour le lien avec le service :
 */
	IClientService clientService;
/**
 * Déclaration des getters et setters :
 */
	public boolean isRendu() {
		return rendu;
	}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}
/**
 * Déclaration des méthodes :
 */
	
	public void getListeCategorie(){
		List<Categorie> listeCategorie = clientService.getAllCategorieService();
		this.rendu = true;	
	}


}

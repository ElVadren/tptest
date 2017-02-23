/**
 * Le managedbean qui gère l'appel des méthodes pour le client
 */


package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.IClientService;

@ManagedBean
@SessionScoped
public class ClientManagedBean implements Serializable {


//déclaration des attributs du ManagedBean : ------------------
	private static final long serialVersionUID = 1L;
	private Client client;
	private List<Produit> listePanier;
	private Produit produit;
	
//instanciation des EJB pour les méthodes
	@EJB
	IClientService clientService;
	
//constructeur vide -----------------------------:
	
	public ClientManagedBean() {
		this.client = new Client();
		this.listePanier = new ArrayList<Produit>();
		this.produit = new Produit ();
		
	}

//getter et setters :
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Produit> getListePanier() {
		return listePanier;
	}

	public void setListePanier(List<Produit> listePanier) {
		this.listePanier = listePanier;
	}
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
//les methodes --------------------------;
	
/**
 * la methode pour ajouter le produit dans le panier : 
 * 1 - récupération des informations complète du produit via son ID
 * 2 - ajout de la quantitée voulue
 * 3 - calcul du nouveau prix de l'ensemble 
 * 4 - ajout du produit à la liste Panier (gardée sur l'ensemble de la session et enregistrée à la commande

 */
	public void ajoutPanier(){
	System.out.println("la quantitée récupérée =");
	System.out.println(produit.getQuantite());
	System.out.println("L'id produit récupéré =");
	System.out.println(produit.getIdProduit());
	int quantite = produit.getQuantite();
	Produit produitadd = clientService.getProduitByIdService(produit.getIdProduit());
	produitadd.setQuantite(quantite);
	double nouveauprix = produitadd.getPrix() * quantite;
	produitadd.setPrix(nouveauprix);
	this.listePanier.add(produitadd);
	}
	
	/**
	 * la methode pour supprimer un produit du panier
	 */
	public void supprimerProduit(){
		this.listePanier.remove(produit);
	}
	
	/**
	 * Cette méthode permet de vider intégralement le panier de la session
	 */
	public void supprimerPanier(){
		this.listePanier.clear();;
	}
}

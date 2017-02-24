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
	private boolean rendu1=false;
	private boolean rendu2=true;
	
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
	this.rendu1=true;
	this.rendu2=false;
	}
	
	/**
	 * la methode pour supprimer un produit du panier :
	 * Si elle le panier est entièrement vidé, reinistialise les boolean utilisés pour l'affichage
	 */
	public void supprimerProduit(){
		this.listePanier.remove(produit);
		if(listePanier.size()==0){
			this.rendu1=false;
			this.rendu2=true;
		}
		
	}
	
	/**
	 * Cette méthode permet de vider intégralement le panier de la session
	 */
	public void supprimerPanier(){
		this.listePanier.clear();
		this.rendu1=false;
		this.rendu2=true;
	}
	

	/**
	 * méthode pour l'enregistrement d'un nouveau client
	 * Cette méthode est uniquement disponible quand il y a des elements dans un panier 
	 * et quand la commande va être passée
	 */
	public String enregistrementClient(){
		clientService.enregistrementClientService(client);
		return "validercommande";
	}
	
	public void savePanier(){
		
	}
	
}

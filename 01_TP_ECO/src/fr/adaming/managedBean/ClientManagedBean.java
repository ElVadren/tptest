/**
 * Le managedbean qui g�re l'appel des m�thodes pour le client
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


//d�claration des attributs du ManagedBean : ------------------
	private static final long serialVersionUID = 1L;
	private Client client;
	private List<Produit> listePanier;
	private Produit produit;
	
//instanciation des EJB pour les m�thodes
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
 * 1 - r�cup�ration des informations compl�te du produit via son ID
 * 2 - ajout de la quantit�e voulue
 * 3 - calcul du nouveau prix de l'ensemble 
 * 4 - ajout du produit � la liste Panier (gard�e sur l'ensemble de la session et enregistr�e � la commande

 */
	public void ajoutPanier(){
	System.out.println("la quantit�e r�cup�r�e ?");
	System.out.println(produit.getQuantite());
	produit = clientService.getProduitByIdService(produit.getIdProduit());
	double nouveauprix = produit.getPrix();
	produit.setPrix(nouveauprix);
	this.listePanier.add(produit);
	}
	
	
}

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
	private long id;
	
//instanciation des EJB pour les méthodes
	@EJB
	IClientService clientService;
	
//constructeur vide -----------------------------:
	
	public ClientManagedBean() {
		this.client = new Client();
		this.listePanier = new ArrayList<Produit>();
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
//les methodes --------------------------;
	


	public void ajoutPanier(){
	System.out.println(id);
	System.out.println("je suis bien dans la methode");
	Produit p = clientService.getProduitByIdService(id);
	System.out.println("Le produit correspondant :");
	System.out.println(p);
	this.listePanier.add(p);
	for(Produit p1:listePanier){
		System.out.println(p1);
	}
	}
	
	
}

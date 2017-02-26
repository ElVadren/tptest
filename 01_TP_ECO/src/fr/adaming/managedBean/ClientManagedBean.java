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
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;
import fr.adaming.service.IClientService;


@ManagedBean
@SessionScoped
public class ClientManagedBean implements Serializable {


/**
 * déclaration des attributs du ManagedBean : ------------------
 */
	private static final long serialVersionUID = 1L;
	private Client client;
	private List<Produit> listePanier;
	private Produit produit;
	private boolean rendu1=false;
	private boolean rendu2=true;
	private boolean connexion=false;
	private List<Commande> listeCommande;
	
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
	

public boolean isConnexion() {
		return connexion;
	}

	public void setConnexion(boolean connexion) {
		this.connexion = connexion;
	}
	
	
	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
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
	this.produit.setQuantite(1);
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
	 * Cette méthode est utilisée pour la validation de la commande. 
	 * Elle se déroule en plusieurs étapes : 
	 * - Si le client c'est déjà identifié dans l'espace, il est detecté via la session -> le client est directement dirigé vers la page finale
	 * - Si l'utilisateur n'est pas identifié, on l'amène vers une page proposant de créer un compte ou de s'identifier
	 */
	
	public String validerCommande(){
		/**
		 * Il ya deux vérification :
		 * - on vérifie s'il y a déjà un nom et un mail dans la session 
		 * - on vérifie ensuite s'ils existent déjà dans la bdd
		 */
				if (this.client.getNomClient() != null) {
					this.client = clientService.isExistService(client);
					if(this.client!=null){
					return "confirmationcommande";
					}
					else {
						return "identification";
					}
				} else {
					return "identification";
				}
	}
	
	public String enregistrementClient(){
		clientService.enregistrementClientService(client);
		return "confirmationcommande";
	}
	
	
	/**
	 * 
	 * C'est la methode utilisée pour l'envois de la commande.
	 * Pour éviter tout soucis, on reverifie ici que le client est bien enregistré en session de manière à éviter une commande lié à un 
	 * client nul.
	 * On verifie également que le panier n'est pas vide.
	 * A la fin de la commande, le panier est vidé et le client redirigé vers une page de confirmation
	 */
	public String confirmerCommande(){
		if (this.client.getNomClient() != null) {
			this.client = clientService.isExistService(client);
			if(this.client!=null && this.listePanier.size()>0){
				clientService.enregistrementCommandeService(client, listePanier);
				this.listePanier.clear();
				return "commandeconfirme";
			}
			return "commandeechec";
			}
		return "commandeechec";
	}
	
	/**
	 * 
	 * Cette méthode permet l'identification d'un Client existant au moment de passer commande
	 * Elle vérifie que celui-ci existe bien, sinon elle recharge la page en affichant un message d'erreur
	 */
	public String identificationClient(){
		Client cr= clientService.isExistService(client);
		if(cr!=null){
			this.connexion=false;
			return "confirmationcommande";
		}else{
		this.connexion=true;
		return "connexionclient";
		}
	}
	
	/**
	 * Cette méthode permet la navigation vers l'espace client, qui permet a un client existant de voir un aperçu de ses commandes.
	 *  La méthode verifie si le client existe, sinon elle le renvois vers la page de connexion. 
	 *  Elle charge également la liste des commandes effectuées.
	 */
	public String espaceClient(){
		Client cr= clientService.isExistService(client);
		if(cr!=null){
			this.listeCommande=clientService.getCommandeByClientService(client);
			this.connexion=false;
			return "espaceclient";
		}else{
		this.connexion=true;
		return "identificationclient";
		}
	}
}

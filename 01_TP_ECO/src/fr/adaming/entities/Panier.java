package fr.adaming.entities;

import java.util.List;





public class Panier extends LigneCommande{

//déclaration des attributs	
	private static final long serialVersionUID = 1L;
	
	


	private List<LigneCommande> ligneCommande;
	

	
	
	
//	get et set

	public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}


	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	
	
//constructeur
	public Panier(List<LigneCommande> ligneCommande) {
		super();
		this.ligneCommande = ligneCommande;
	}


	public Panier() {
		super();
	}
	
	
}

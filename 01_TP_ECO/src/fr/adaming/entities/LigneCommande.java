package fr.adaming.entities;

import java.io.Serializable;

/**
 * 
 * lasse Ligne commande
 *
 */


public class LigneCommande implements Serializable {


//les attributs ----------------------:
	
	private static final long serialVersionUID = 1L;
	private long idLigneCommande;
	private int quantite;
	private double prix;
	
//les constructeurs --------------------:
	
	//vide
	public LigneCommande() {
		super();
	}
	
	//quantité + prix
	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	//complet :
	public LigneCommande(long idLigneCommande, int quantite, double prix) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.quantite = quantite;
		this.prix = prix;
	}

//getter et setters -----------------------:
	public long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
//methodes -----------------------:
	
	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
	

	
}

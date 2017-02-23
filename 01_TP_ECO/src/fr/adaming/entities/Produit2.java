/**
 * Déclaration de la classe Produit 
 */


package fr.adaming.entities;

import java.io.Serializable;

public class Produit implements Serializable {


	
//-------------déclaration des attributs :
	private static final long serialVersionUID = 1L;
	private long idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private boolean selectionne;

	
//---------- déclaration des constructeurs :
	
		//un vide	
	public Produit() {
		super();
	}

	//constructeur avec designation, description, prix (pour création)
	public Produit(String designation, String description, double prix) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		
	}

	//constructeur complet
	public Produit(long idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		
	}

//-------------getters et setters :
	
	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}



	
//------------les méthodes :
	
	//méthode toString qui affiche Id, designation, description, prix
	

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + "]";
	}

	
}

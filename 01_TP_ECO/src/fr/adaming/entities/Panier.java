package fr.adaming.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Panier extends LigneCommande{

//déclaration des attributs	
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy="panier")
	private List<LigneCommande> ligneCommande;
	

	private long id;
	
	
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

package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * classe Ligne commande
 *
 */

@Entity
@Table(name="ligne_commandes")
public class LigneCommande implements Serializable {


//les attributs ----------------------:
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long idLigneCommande;
	@Column(name="quantite")
	private int quantite;
	@Column(name="prix")
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="panier_id_fk", referencedColumnName="id_panier")
	private Panier panier;
	
	
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

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	
//methodes -----------------------:
	

	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
	

	
}

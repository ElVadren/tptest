package fr.adaming.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	/**	C'est un produit comamandé, il récupère tt les attributs du produit
	 * Avec sa quantité et prix modifié 
	 * Il aura sa propre table
	 * Chaque ligne de commande peut être attribuée à un panier
	 */

	
	/**
	 * -------------déclaration des attributs :
	 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id_produit")
		private long idProduit;
		@Column(name="designation_produit")
		private String designation;
		@Column(name="description_produit")
		private String description;
		@Column(name="prix_produit")
		private double prix;
		@Column(name="quantite_produit")
		private int quantite;
	
	/**
	 * --------------declaration des liaisons :	
	 */
		@ManyToOne
		@JoinColumn(name="panier_id_fk", referencedColumnName="id_panier")
		private Panier panier;
		
		
	/**
	 * ---------- déclaration des constructeurs :
	 */
	
		public LigneCommande() {
			super();
		}
		

	public LigneCommande(String designation, String description, double prix, int quantite) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}




	/**
	 * -------------getters et setters :
	 * @return
	 */
		
	
		
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

		public Panier getPanier() {
			return panier;
		}


		public void setPanier(Panier panier) {
			this.panier = panier;
		}
	/**
	 * ------------les méthodes :
	 */
		
		


		/**
		 * méthode toString qui affiche Id, designation, description, prix
		 */
		

		@Override
		public String toString() {
			return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
					+ ", prix=" + prix + "]";
		}

		



	


	

	
}

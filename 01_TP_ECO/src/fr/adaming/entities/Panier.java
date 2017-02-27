package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * classe produit
 * 
 *
 */

@Entity
@Table(name="paniers")
public class Panier implements Serializable{

/**
 * déclaration des attributs	
 */
	private static final long serialVersionUID = 1L;
	
	

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id_panier")
	private long id;

	/**
	 * association avec la classe Panier 
	 */
	@OneToMany(mappedBy="panier", cascade=CascadeType.ALL)
	private List<LigneCommande> listProduit;
	
	@OneToOne(mappedBy="panier")
	private Commande commande;
	
	/**
	 * constructeurs vides
	 */
	
	public Panier() {
		super();
	}

	

/**
 * get et set
 * @return
 */

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	


	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}





	public List<LigneCommande> getListProduit() {
		return listProduit;
	}





	public void setListProduit(List<LigneCommande> listProduit) {
		this.listProduit = listProduit;
	}
	

	
	

	
	
}

package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="paniers")
public class Panier implements Serializable{

//déclaration des attributs	
	private static final long serialVersionUID = 1L;
	
	

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id_panier")
	private int id;

	
	@OneToMany(mappedBy="panier")
	private List<LigneCommande> listProduit;
	
	@OneToOne(mappedBy="panier")
	private Commande commande;
	
	
	
	public Panier() {
		super();
	}

	



	public int getId() {
		return id;
	}


	public void setId(int id) {
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

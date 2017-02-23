package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie implements Serializable {

	@Id
	@Column(name="id_categorie")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	attributs
	private long idCategorie;
	private String nomCategorie;
	private String description;
	
//	clé étrangère de la classe produit : association d'une liste de produit à une catégorie
	@OneToMany(mappedBy="categorie")
	private List<Produit> listProduit;
	
	
	
//	get et set
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
//	constructeurs
	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	public Categorie(long idCategorie, String nomCategorie, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	public Categorie() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description="
				+ description + "]";
	}
	
	
	
	
	
}

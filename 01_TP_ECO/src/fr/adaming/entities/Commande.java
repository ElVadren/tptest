/**
 * Déclaration de la classe Commande :
 */

package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commandes")
public class Commande implements Serializable {

//----------------les attributs :
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private long idCommande;
	@Column(name="date_commande")
	private Date dateCommande;

//déclaration des liaisons :
	
	//liaison entre commande et produits :
	@ManyToMany(mappedBy="listeCommande")
	@JoinColumn(name="produit_id_fk", referencedColumnName="id_produit")
	private List<Produit> listeProduit;
	
	//liaison entre commandes et clients :
	@ManyToOne
	@JoinColumn(name="client_id_fk", referencedColumnName="id_client")
	private Client client;
	
//--------------Constructeurs :
	
	//un vide
	public Commande() {
		super();
	}

	//un avec la date
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	//un complet
	public Commande(long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

//getter et setters -----------------:
	public long getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	//pour la liste produit
	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	
	//clients
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//-------------------------les méthodes :	
	//réecriture toString
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}
	

}

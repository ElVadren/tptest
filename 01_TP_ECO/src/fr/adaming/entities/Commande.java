/**
 * Déclaration de la classe Commande :
 */

package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="commandes")
public class Commande implements Serializable {

/**
 * ----------------les attributs :
 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private long idCommande;
	@Column(name="date_commande")
	private Date dateCommande;

/**
 * déclaration des liaisons :
 */
	

	/**
	 * liaison entre commandes et clients :
	 */
	@ManyToOne
	@JoinColumn(name="client_id_fk", referencedColumnName="id_client")
	private Client client;
	
	/**
	 * liaison entre commande et panier
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="panier_id_fk", referencedColumnName="id_panier")
	private Panier panier;
	
/**
 * --------------Constructeurs :
 */
	
	/**
	 * un vide
	 */
	public Commande() {
		super();
	}

	/**
	 * un avec la date
	 * @param dateCommande
	 */
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	/**
	 * un complet
	 * @param idCommande
	 * @param dateCommande
	 */
	public Commande(long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

/**
 * getter et setters -----------------:
 * @return
 */
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



	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	/**
	 * clients
	 * @return
	 */
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * -------------------------les méthodes :	
	 */
	/**
	 * réecriture toString
	 */
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}
	

}

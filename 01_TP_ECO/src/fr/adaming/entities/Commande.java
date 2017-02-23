/**
 * Déclaration de la classe Commande :
 */

package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {

//----------------les attributs :
	private static final long serialVersionUID = 1L;
	private long idCommande;
	private Date dateCommande;
	
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


	
//-------------------------les méthodes :	
	//réecriture toString
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}
	

}

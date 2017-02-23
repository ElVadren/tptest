/**
 * Declaration de la classe Client
 */

package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable{

	
//déclaration des attributs -----------------:
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private long idClient;
	@Column(name="nom_client")
	private String nomClient;
	@Column(name="adresse_client")
	private String adresse;
	@Column(name="email_client")
	private String email;
	@Column(name="tel_client")
	private String tel;
	
//	clé étrangère de la classe Commande : associe une liste de commande à un client
	@OneToMany(mappedBy="client")	
	private List<Commande> listCommande;
	
//déclaration des constructeurs ---------------:
	
	//un vide
	public Client() {
		super();
	}

	//un sans id
	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	//un complet
	public Client(long idClient, String nomClient, String adresse, String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	
//getters et setters ----------------------------:
	
	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public List<Commande> getListCommande() {
		return listCommande;
	}

	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}
	

//les méthodes --------------------------:
	


	//toString 
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + "]";
	}
	

	
}

package fr.adaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//classe admin

@Entity
@Table(name="admin")
public class Admin {
	
//	attributs
	@Id
	@Column(name="id_admin")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAdmin;
	
	@Column(name="nom_admin")
	private String nomAdmin;
	@Column(name="password_admin")
	private String passwordAdmin;
	
//	get et set
	public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNomAdmin() {
		return nomAdmin;
	}
	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}
	public String getPasswordAdmin() {
		return passwordAdmin;
	}
	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
//	constructeurs
	public Admin(long idAdmin, String nomAdmin, String passwordAdmin) {
		super();
		this.idAdmin = idAdmin;
		this.nomAdmin = nomAdmin;
		this.passwordAdmin = passwordAdmin;
	}
	
	
public Admin() {
	super();
}
@Override
public String toString() {
	return "Admin [idAdmin=" + idAdmin + ", nomAdmin=" + nomAdmin + ", passwordAdmin=" + passwordAdmin + "]";
}
	
	

	
}

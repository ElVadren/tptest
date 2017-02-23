package fr.adaming.entities;

//classe admin
public class Admin {
	
//	attributs
	private long idAdmin;
	private String nomAdmin;
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
	
	

	
}

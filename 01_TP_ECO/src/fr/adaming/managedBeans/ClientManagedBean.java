/**
 * Le managedbean qui g�re l'appel des m�thodes pour le client
 */


package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.entities.Client;

@ManagedBean
@SessionScoped
public class ClientManagedBean implements Serializable {


//d�claration des attributs du ManagedBean : ------------------
	private static final long serialVersionUID = 1L;
	private Client client;
	
	
}

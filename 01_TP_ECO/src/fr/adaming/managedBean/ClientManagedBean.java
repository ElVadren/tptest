/**
 * Le managedbean qui gère l'appel des méthodes pour le client
 */


package fr.adaming.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.entities.Client;

@ManagedBean
@SessionScoped
public class ClientManagedBean implements Serializable {


//déclaration des attributs du ManagedBean : ------------------
	private static final long serialVersionUID = 1L;
	private Client client;
	
	
}

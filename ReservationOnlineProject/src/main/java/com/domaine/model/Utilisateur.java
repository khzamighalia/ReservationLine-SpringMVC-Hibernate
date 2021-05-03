package com.domaine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.OneToMany;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nom_complet")
	private String nom_complet;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mdp")
	private String mdp; 
	
	
	private int active;
//	
//	
//	@OneToMany(mappedBy = "utilisateur", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//	private List<Reservation> reservations = new ArrayList<Reservation>();

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom_complet=" + nom_complet + ", email=" + email + ", mdp=" + mdp
				+ ", active=" + active;
	}

	public Utilisateur(String nom_complet, String email, String mdp) {
		super();
		this.nom_complet = nom_complet;
		this.email = email;
		this.mdp = mdp;
		this.active = 0;	}

	public Utilisateur() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom_complet() {
		return nom_complet;
	}

	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}

}

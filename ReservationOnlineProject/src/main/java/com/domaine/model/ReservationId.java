package com.domaine.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
public class ReservationId implements Serializable {
	@ManyToOne
	@JoinColumn(name="user_id")
	private Utilisateur user; 
	@ManyToOne
	@JoinColumn(name="gestion_id")
	private Gestion gestion;
	
	public ReservationId(Utilisateur user, Gestion gestion) {
		super();
		this.user = user;
		this.gestion = gestion;
	} 
	public ReservationId() {
		super();
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Gestion getGestion() {
		return gestion;
	}
	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	} 
	
}

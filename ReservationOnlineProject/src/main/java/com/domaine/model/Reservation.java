package com.domaine.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gestionResrv")
public class Reservation {


	@EmbeddedId
	private ReservationId id;
		
	@Column(name = "etat")
	private int etat;
	
	public Reservation(ReservationId id, Date date, int etat) {
		super();
		this.id = id;
		this.etat = etat;
	}
	public Reservation() {
		super();
	}
	public ReservationId getId() {
		return id;
	}
	public void setId(ReservationId id) {
		this.id = id;
	}
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	


	

}

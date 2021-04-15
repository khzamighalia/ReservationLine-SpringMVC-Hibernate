package com.domaine.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Gestion  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_gest")
	private Long id_gest;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date")
	private Date date ;
	
	@Column(name = "nmbr_places")
	private int nmbr_places;
	
	
	/*@ManyToOne
	@JoinColumn(name = "id")
    private User user;
	*/
		
	public Gestion(Date date ,int nmbr_places) {
		super();
		this.date = date;
		this.nmbr_places = nmbr_places;
	}
	
	public Gestion() {
		super();
	}
	public Long getId_gest() {
		return id_gest;
	}

	public void setId_gest(Long id_gest) {
		this.id_gest = id_gest;
	}

	public int getNmbr_places() {
		return nmbr_places;
	}

	public void setNmbr_places(int nmbr_places) {
		this.nmbr_places = nmbr_places;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



}

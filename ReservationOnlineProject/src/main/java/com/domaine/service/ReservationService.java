package com.domaine.service;

import java.util.List;

import com.domaine.model.Reservation;
import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;

public interface ReservationService {
	public void create(Reservation reservation);
	public void update(Reservation reservation);
	public List<Reservation> getByUtilisateur(Utilisateur utilisateur);
	public List<Reservation> getByReserver(Gestion gestion);
	public Reservation getByReserverUtilisateur(Gestion gestion, Utilisateur utilisateur);
	public void refuseAllReservation(Gestion gestion);
}

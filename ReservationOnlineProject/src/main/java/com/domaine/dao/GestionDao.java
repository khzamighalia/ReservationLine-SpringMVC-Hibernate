package com.domaine.dao;

import java.util.List;

import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;

public interface GestionDao {
	public void create(Gestion gestion);
	public void update(Gestion gestion);
	public Gestion find(Long id);
	public List<Gestion> getReserverWeek();
	public List<Gestion> getReserverProchain();
	public List<Gestion> getReserverProchainUser(Utilisateur user);
	public List<Gestion> getReservationDispo();

	
}

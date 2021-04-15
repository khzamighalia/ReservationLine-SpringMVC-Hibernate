package com.domaine.service;

import java.util.List;

import com.domaine.model.Utilisateur;
import com.domaine.model.UtilisateurConnection;

public interface UtilisateurService {
	public void create(Utilisateur User);
	public void update(Utilisateur User);
	public Utilisateur find(Long id);
	public Utilisateur login(UtilisateurConnection user);
	public List<Utilisateur> getAllApprenant();
	public Utilisateur findByEmail(String email);
	public List<Utilisateur> getAllApprenantInvalid();
}

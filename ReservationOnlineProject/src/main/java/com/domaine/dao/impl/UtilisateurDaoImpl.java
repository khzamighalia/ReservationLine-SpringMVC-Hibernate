package com.domaine.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domaine.model.Utilisateur;
import com.domaine.model.UtilisateurConnection;
import com.domaine.dao.UtilisateurDao;

@Repository("utilisateurDao")
public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Utilisateur user) {
		currentSession().save(user);
	}

	@Override
	public void update(Utilisateur User) {
		currentSession().update(User);
	}

	@Override
	public Utilisateur find(Long id) {
		return (Utilisateur)currentSession().get(Utilisateur.class, id);
	}

	@Override
	public Utilisateur login(UtilisateurConnection user) {
		Utilisateur utilisateur = findByEmail(user.getEmail());
		if(utilisateur != null) {
			if(! BCrypt.checkpw(user.getMdp(), utilisateur.getMdp())) {
				utilisateur = null;
			}
		}
		return utilisateur;
	}

	@Override
	public List<Utilisateur> getAllApprenant() {
		return currentSession().createQuery("from Utilisateur where role = 'user'", Utilisateur.class).list();
	}

	@Override
	public Utilisateur findByEmail(String email) {
		return (Utilisateur)currentSession().createQuery("from Utilisateur where email = :email", Utilisateur.class).setParameter("email", email).uniqueResult();
	}

	@Override
	public List<Utilisateur> getAllApprenantInvalid() {
		return currentSession().createQuery("from Utilisateur where active = 0", Utilisateur.class).list();
	}

}

package com.domaine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domaine.model.Utilisateur;
import com.domaine.model.UtilisateurConnection;
import com.domaine.dao.UtilisateurDao;
import com.domaine.service.UtilisateurService;

@Service("utilisateurService")
@Transactional(propagation = Propagation.SUPPORTS, noRollbackFor = Exception.class)
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	UtilisateurDao utilisateurDao;
	
	@Transactional
	@Override
	public void create(Utilisateur User) {
		utilisateurDao.create(User);
	}

	@Transactional
	@Override
	public void update(Utilisateur User) {
		utilisateurDao.update(User);
	}

	@Transactional
	@Override
	public Utilisateur find(Long id) {
		return utilisateurDao.find(id);
	}

	@Transactional
	@Override
	public Utilisateur login(UtilisateurConnection user) {
		return utilisateurDao.login(user);
	}

	@Transactional
	@Override
	public List<Utilisateur> getAllApprenant() {
		return utilisateurDao.getAllApprenant();
	}

	@Transactional
	@Override
	public Utilisateur findByEmail(String email) {
		return utilisateurDao.findByEmail(email);
	}

	@Transactional
	@Override
	public List<Utilisateur> getAllApprenantInvalid() {
		return utilisateurDao.getAllApprenantInvalid();
	}

}

package com.domaine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;
import com.domaine.dao.GestionDao;
import com.domaine.service.GestionService;

@Service("reserverService")
@Transactional(propagation = Propagation.SUPPORTS, noRollbackFor = Exception.class)
public class GestionServiceImpl implements GestionService {

	@Autowired
	GestionDao gestionDao;
	
	@Transactional
	@Override
	public void create(Gestion gestion) {
		gestionDao.create(gestion);
	}
	
	@Transactional
	@Override
	public void update(Gestion gestion) {
		gestionDao.update(gestion);
	}

	@Transactional
	@Override
	public Gestion find(Long id_gestion) { //CHANGE ID
		return gestionDao.find(id_gestion);
	}
	
	@Transactional
	@Override
	public List<Gestion> getReserverWeek() {
		return gestionDao.getReserverWeek();
	}
	
	@Transactional
	@Override
	public List<Gestion> getReserverProchain() {
		return gestionDao.getReserverProchain();
	}
	
	@Transactional
	@Override
	public List<Gestion> getReserverProchainUser(Utilisateur user) {
		return gestionDao.getReserverProchainUser(user);
	}

}

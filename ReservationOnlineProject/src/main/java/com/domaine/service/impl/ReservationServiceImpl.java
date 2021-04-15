package com.domaine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domaine.model.Reservation;
import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;
import com.domaine.dao.ReservationDao;
import  com.domaine.service.ReservationService;

@Service("reservationService")
@Transactional(propagation = Propagation.SUPPORTS, noRollbackFor = Exception.class)
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Transactional
	@Override
	public void create(Reservation reservation) {
		reservationDao.create(reservation);
	}
	
	@Transactional
	@Override
	public void update(Reservation reservation) {
		reservationDao.update(reservation);
	}

	@Transactional
	@Override
	public List<Reservation> getByUtilisateur(Utilisateur utilisateur) {
		return reservationDao.getByUtilisateur(utilisateur);
	}

	@Transactional
	@Override
	public List<Reservation> getByReserver(Gestion gestion) {
		return reservationDao.getByReserver(gestion);
	}

	@Transactional
	@Override
	public Reservation getByReserverUtilisateur(Gestion gestion, Utilisateur utilisateur) {
		return reservationDao.getByReserverUtilisateur(gestion, utilisateur);
	}

	@Transactional
	@Override
	public void refuseAllReservation(Gestion gestion) {
		reservationDao.refuseAllReservation(gestion);
	}

}

package com.domaine.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domaine.model.Reservation;
import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;
import com.domaine.dao.ReservationDao;

@Repository("reservationDao")
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Reservation reservation) {
		currentSession().save(reservation);
	}

	@Override
	public void update(Reservation reservation) {
		currentSession().update(reservation);
	}

	@Override
	public List<Reservation> getByUtilisateur(Utilisateur utilisateur) {
		return currentSession().createQuery("from Gestionresrv where user_id = :utilisateur order by gestion_id.dateReserver " ,Reservation.class).setParameter("utilisateur", utilisateur).list();
	}

	@Override
	public List<Reservation> getByReserver(Gestion gestion) {
		return currentSession().createQuery("from Gestionresrv where gestion_id = :gestion and etat=0 order by id.user.nbrReservation" ,Reservation.class).setParameter("getsion", gestion).list();
	}

	@Override
	public Reservation getByReserverUtilisateur(Gestion gestion, Utilisateur utilisateur) {
		return currentSession().createQuery("from Gestionresrv where id.reserver = :gestion and id.user=:user" ,Reservation.class).setParameter("reserver", gestion).setParameter("user", utilisateur).uniqueResult();
	}

	@Override
	public void refuseAllReservation(Gestion gestion) {
		currentSession().createQuery("UPDATE Gestionresrv SET etat=2 where etat=0 and id.reserver=:reserver").setParameter("reserver", gestion).executeUpdate();
	}

}

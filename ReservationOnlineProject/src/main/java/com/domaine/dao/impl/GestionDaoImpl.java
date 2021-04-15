package com.domaine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;

import com.domaine.dao.GestionDao;

@Repository("gestionDao")
public class GestionDaoImpl implements GestionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Gestion gestion) {
		currentSession().save(gestion);
	}
	
	@Override
	public void update(Gestion gestion) {
		currentSession().update(gestion);
	}

	@Override
	public Gestion find(Long id) {
		return currentSession().get(Gestion.class, id);
	}
	@Override
	public List<Gestion> getReserverProchain() {
		return currentSession().createQuery("from Gestion where nmbr_places > 0 and date >= current_date",Gestion.class).list();
	}
	

	@Override
	public List<Gestion> getReserverProchainUser(Utilisateur user) {
		return currentSession().createQuery("from Gestion where id not in (select gestion_id from Gestionresrv  "
				+ "where G.gestion_id.user_id:user) order by date",Gestion.class).setParameter("user", user).list();
	}

	@Override
	public List<Gestion> getReserverWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

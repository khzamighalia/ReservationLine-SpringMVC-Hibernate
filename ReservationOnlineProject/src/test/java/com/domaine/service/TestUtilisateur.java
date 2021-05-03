package com.domaine.service;

import static org.junit.Assert.assertNotNull; 
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domaine.model.Utilisateur;
import com.domaine.model.UtilisateurConnection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/dispatcher-config.xml" })
public class TestUtilisateur {

	@Autowired
	UtilisateurService utilisateurService;
	
	@Test
	public void findByEmailTest() {
		Utilisateur user = utilisateurService.findByEmail("admin@gmail.com");
		assertNotNull(user);
	}
	@Test
	public void findTest() {
		Utilisateur user = utilisateurService.find(29L);
		assertNotNull(user);
	}
	
	@Test
	public void loginTest() {
		Utilisateur user = utilisateurService.login(new UtilisateurConnection("admin@gmail.com", "admin"));
		assertNotNull(user);
		assertEquals(3, user.getActive());
	}
	
	@Test
	public void getAllApprenantTest() {
		List<Utilisateur> list = utilisateurService.getAllApprenant();
		assertNotNull(list);
		assertEquals(1, list.get(0).getActive());
	}

	
	
}

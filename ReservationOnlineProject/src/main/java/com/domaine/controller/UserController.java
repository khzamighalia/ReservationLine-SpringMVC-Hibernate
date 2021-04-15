package com.domaine.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domaine.model.Reservation;
import com.domaine.model.ReservationId;
import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;
import com.domaine.service.ReservationService;
import com.domaine.service.GestionService;
import com.domaine.service.UtilisateurService;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@Autowired
	GestionService gestionService;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/demandesAcces")
	public String demandesAcces(Model model, HttpSession httpSession) {
		System.out.println(gestionService.getReserverProchainUser((Utilisateur)httpSession.getAttribute("logged")).size());
		model.addAttribute("listReserver", gestionService.getReserverProchainUser((Utilisateur)httpSession.getAttribute("logged")));
		model.addAttribute("listDemande", reservationService.getByUtilisateur((Utilisateur)httpSession.getAttribute("logged")));
		return "user/demandesAcces";
	}
	
	//demande d'inscription
	@RequestMapping(value="/demandesAcces", method = RequestMethod.POST)
	public void AjouterdemandesAcces(Model model, HttpSession httpSession, @RequestParam(name = "id_gest") Long id_gest) {
		Utilisateur user = (Utilisateur)httpSession.getAttribute("logged");
		Gestion gestion= gestionService.find(id_gest);
		//System.out.println(gestion.getNombrePlace());
		reservationService.create(new Reservation(new ReservationId(user, gestion), null, 0));
		model.addAttribute("succes", "l'ajout de demande d'accés est terminé avec succès");
		demandesAcces(model, httpSession);
	}
	
}

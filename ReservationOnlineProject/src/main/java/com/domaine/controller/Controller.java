package com.domaine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.domaine.model.Reservation;
import com.domaine.model.Utilisateur;
import com.domaine.model.UtilisateurConnection;
import com.domaine.service.GestionService;
import com.domaine.service.ReservationService;
import com.domaine.service.UtilisateurService;


@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private GestionService gestionService;
	
	@Autowired
	private ReservationService reservationService;

	@GetMapping("/")
	private String index() {
		return "connexion";
	}
	
	@GetMapping("/register")
	private String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String inscriptionAprenant(Model model, @RequestParam(name = "nom") String nom ,@RequestParam(name = "email") String email, @RequestParam(name = "mdp") String mdp) {
		Utilisateur user = utilisateurService.findByEmail(email);
		if(user != null) {
			model.addAttribute("erreur", "l'email existe déjà");
		} else {
			try {
				Utilisateur utilisateur = new Utilisateur(nom, email, BCrypt.hashpw(mdp, BCrypt.gensalt()));
				utilisateurService.create(utilisateur);
				model.addAttribute("succes", "l'inscription est termin� avec succès");
				return "connexion";
			} catch (Exception e) {
				model.addAttribute("erreur", e);
			}
		}
		System.out.println(user);
		return "register";
	}
	
	@RequestMapping("/connexion")
	public String login() {
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String connexion(Model model, UtilisateurConnection user, HttpSession httpSession) {
		Utilisateur utilisateur = utilisateurService.login(user);
		if(utilisateur != null) {
			if (utilisateur.getActive() == 1) {
				httpSession.setAttribute("logged", utilisateur);
				return "redirect:/apprenant";
			} else if (utilisateur.getActive() == 0) {
				model.addAttribute("erreur", "Votre demande d'inscription n'a pas encore été acceptée");
				return "connexionAtt";
			} else if (utilisateur.getActive() == 2) {
				model.addAttribute("erreur", "Votre demande d'inscription a �t� rejet�e");
				System.out.println("rejected");
				return "connexionError";
			}
			else if (utilisateur.getActive() == 3) {
				httpSession.setAttribute("admin logged", utilisateur);
				return "redirect:/admin/demandeInscription";
			} 
		} else {
			model.addAttribute("erreur", "Email ou mot de passe est incorrect");
		}
		return "connexion";
	}
	
	
	@RequestMapping("/deconnexion")
	public String deconnexion(HttpSession httpSession) {
		httpSession.invalidate(); //d�connection de la session, vider la session
		return "redirect:/"; //return to "/"
	}
	
	@RequestMapping("/apprenant")
	public String apprenant(Model model) {
		model.addAttribute("listReservationDispo", gestionService.getReservationDispo());
		return "user/apprenant";
	}
	
	@RequestMapping("/connexionError")
	public String connexionError(HttpSession httpSession) {
		httpSession.invalidate(); //d�connection de la session, vider la session
		return "connexionError"; //return to "/"
	}
	
	
	@RequestMapping("/getAll")
	public String getAll() {
		List<Reservation> a = reservationService.getAllReservations();
		for(Reservation res : a) {
			System.out.println(res.toString());
		}
		return "connexionError";
	}
	
	
	
	
	
	
}

package com.domaine.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.domaine.model.Gestion;
import com.domaine.model.Utilisateur;
import com.domaine.service.GestionService;
import com.domaine.service.ReservationService;
import com.domaine.service.UtilisateurService;


@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	GestionService gestionService;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/demandeInscription")
	public String demandeInscription(Model model) {
		model.addAttribute("listUser", utilisateurService.getAllApprenantInvalid());
		model.addAttribute("listRes", gestionService.getReservationDispo());
		return "admin/demandeInscription";
	}
	
	@RequestMapping(value = "/demandeInscription", method = RequestMethod.POST, params = "accepter")
	public String accepterInscription(Utilisateur user) {
		user = utilisateurService.find(user.getId());
		user.setActive(1);
		utilisateurService.update(user);
		return "redirect:/admin/demandeInscription";
	}
	
	@RequestMapping(value = "/demandeInscription", method = RequestMethod.POST, params = "refuser")
	public String refuserInscription(Utilisateur user) {
		user = utilisateurService.find(user.getId());
		user.setActive(2);
		utilisateurService.update(user);
		return "redirect:/admin/demandeInscription";
	}
	
//	@RequestMapping("/demandeAcces")
//	public String demandeAcces(Model model) {
//		model.addAttribute("listReserver", gestionService.getReserverProchain());
//		return "admin/demandeAcces";
//	}
//	
//	@RequestMapping(value="/demandeAcces", method = RequestMethod.POST, params = "selectionner")
//	public void selectionnerDemandeAcces(Model model, @RequestParam(name = "id_reserver") Long id_reserver) {
//		model.addAttribute("listDemande", reservationService.getByReserver(gestionService.find(id_reserver)));
//		model.addAttribute("succes", id_reserver);
//		demandeAcces(model);
//	}

	//save gestion reservation
	@RequestMapping(value = "/registeresrv123", method = RequestMethod.POST)
	public String inscriptionAprenant(Model model,@RequestParam(name = "date") String date ,@RequestParam(name = "nmbr_places") int nmbr_places) {
		//Gestion g = gestionService.find(id_gestion);
			try {
				DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date date1 = format.parse(date);
				System.out.println(date1);
				Gestion gestion = new Gestion(date1, nmbr_places);
				gestionService.create(gestion);
				model.addAttribute("succes", "l'ajout est termin� avec succ�s");
				return "redirect:/admin/gestionajoutee";
			} catch (Exception e) {
				model.addAttribute("erreur", e);
			}
		return "redirect:/admin/gestionajoutee";
	}
	
	@RequestMapping("/gestionajoutee")
	public String gestionajoutee(Model model) {
		model.addAttribute("listUser", utilisateurService.getAllApprenantInvalid());
		model.addAttribute("listRes", gestionService.getReservationDispo());
		return "admin/gestionajoutee";

	}
}

package com.poesifacile.java.controller;

import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.UtilisateurRepository;
import com.poesifacile.java.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UtilisateurController {
	@Autowired
	private
	UtilisateurRepository utilisateurRepository;

	@RequestMapping("/wallOfFame")
	public ArrayList<Utilisateur> wOF() {
		UtilisateurService utilisateurService = new UtilisateurService(utilisateurRepository, null);
		utilisateurService.setWallOfFame(utilisateurService.trieScore());
		return utilisateurService.getWallOfFame();
	}

	@RequestMapping("/updateDB")
	public boolean updateDB() {
		UtilisateurService utilisateurService = new UtilisateurService(utilisateurRepository, null);
		return utilisateurService.recupMoyenne();
	}
}
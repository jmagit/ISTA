package com.ista.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ista.demo.repositories.ActorRepository;

@Controller
@RequestMapping(path="/actores")
public class ActoresController {
	@Autowired
	private ActorRepository dao;
	
	@GetMapping(path="")
	public String list(Model model, Pageable page) {
		model.addAttribute("listado", dao.findAll(page));
		return "actores/list";
	}
}

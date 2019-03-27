package com.ista.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.ista.demo.model.Actor;
import com.ista.demo.repositories.ActorRepository;

@Controller
@RequestMapping(path="/actores")
public class ActoresController {
	@Autowired
	private ActorRepository dao;
	
	@GetMapping(path="")
	public String list(Model model, @PageableDefault(size=10, sort = {"firstName", "lastName"})  Pageable page) {
		model.addAttribute("listado", dao.findAll(page));
		return "actores/list";
	}
	@GetMapping(path="/{id:\\d+}/**")
	public String view(@PathVariable Long id, Model model) {
		Optional<Actor> item = dao.findById(id);
		if(!item.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		model.addAttribute("elemento", item.get());
		return "actores/view";
	}
}

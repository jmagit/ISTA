package com.ista.demo.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

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
	@GetMapping("/add")
	public String addGET(Model model) {
		model.addAttribute("modo", "add");
		model.addAttribute("action", "actores/add");
		model.addAttribute("elemento", new Actor());
		return "actores/form";
	}
	@PostMapping("/add")
	public ModelAndView addPOST(@ModelAttribute("elemento") @Valid Actor item, 
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(dao.findById(item.getActorId()).isPresent())
			result.addError(new FieldError("elemento", "actorId", "Clave duplicada"));
		if(result.hasErrors()) {
			mv.addObject("modo", "add");
			mv.addObject("action", "actores/add");
			mv.addObject("elemento", item);
			mv.setViewName("actores/form");
		} else {
			dao.save(item);
			mv.setViewName("redirect:/actores");
		}
		return mv;
	}

	@GetMapping("/{id:\\d+}/edit")
	public String editGET(@PathVariable Long id, Model model) {
		Optional<Actor> item = dao.findById(id);
		if(!item.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		model.addAttribute("modo", "edit");
		model.addAttribute("action", "actores/" + id + "/edit");
		model.addAttribute("elemento", item.get());
		return "actores/form";
	}
	@PostMapping("/{id:\\d+}/edit")
	public ModelAndView editPOST(@PathVariable Long id, @ModelAttribute("elemento") @Valid Actor item, 
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(id != item.getActorId())
			result.addError(new FieldError("elemento", "actorId", "Clave invalida"));
		if(result.hasErrors()) {
			mv.addObject("modo", "edit");
			mv.addObject("action", "actores/" + id + "/edit");
			mv.addObject("elemento", item);
			mv.setViewName("actores/form");
		} else {
			if(!dao.findById(item.getActorId()).isPresent())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			dao.save(item);
			mv.setViewName("redirect:/actores");
		}
		return mv;
	}
	
	@GetMapping("/{id:\\d+}/delete")
	public String editGET(@PathVariable Long id) {
		try {
			dao.deleteById(id);
		} catch (Exception e) {
		}
		return "redirect:/actores";
	}
	
}

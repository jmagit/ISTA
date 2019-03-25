package com.ista.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemosController {
	@RequestMapping(path="/saluda")
	public String Saludar(Model model) {
		model.addAttribute("nombre", "mundo");
		return "saludar";
	}
}

package com.ista.demo.controllers;

import javax.servlet.ServletRequest;

import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemosController {
	@RequestMapping(path="/saluda")
	public String saludar(@RequestParam(name="nom", defaultValue="Mundo") String nombre, 
			@RequestHeader("Accept-Language") String language, 
			Model model) {
		model.addAttribute("nombre", language);
		return "saludar";
	}
	@RequestMapping(path="/saluda*/{nombre:\\d+}/**")
	public String saludar2(@PathVariable String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		return "saludar";
	}
	@RequestMapping(path="/demo/kk")
	public ModelAndView saludar2(ServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("nombre", req.getLocalPort());
		mv.setViewName("saludar");
		return mv;
	}
}

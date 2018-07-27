package br.com.uol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RouteController {
	
	@GetMapping
	public String home() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String registration() {
		return "registration";
	}
	
	@GetMapping("/editar")
	public String edit() {
		return "edit";
	}

}

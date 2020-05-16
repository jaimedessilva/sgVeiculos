package com.sgveiculos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**Project: sgveiculos
 * File: PageController.java
 * @author jaime
 * Em 13-05-2020 **/

@Controller
public class PageController {
	@GetMapping("/")
	public String login() {
		return "/login";
	}
	@GetMapping("/home")
	public String home () {
		return "/home";
	}
	@GetMapping("/menu")
	public String menu () {
		return "/_menu";
	}
	@GetMapping("/lista")
	public String proprietarios () {
		return "/list-proprietarios";
	}
	@GetMapping("/user")
	public String user() {
		return "/user";
	}
	@GetMapping("/form-proprietario")
	public String formProp() {
		return "/form-cad-properietario";
	}
	@GetMapping("/form-veiculo")
	public String cadVeiculos () {
		return "form-cad-veiculo";
	}
	@GetMapping("/form-usuario")
	public String cadUsuario () {
		return "form-cad-usuario";
	}
	@GetMapping("/veiculos")
	public String listVeiculos () {
		return "/list-veiculos";
	}
	@GetMapping("/usuarios")
	public String listUsuarios () {
		return "/list-usuarios";
	}
	
}

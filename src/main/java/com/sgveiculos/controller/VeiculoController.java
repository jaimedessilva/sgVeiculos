package com.sgveiculos.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sgveiculos.model.Veiculo;
import com.sgveiculos.repository.VeiculoRepository;

/**Project: sgveiculos
 * File: VeiculoController.java
 * @author jaime
 * Em 17-05-2020 **/

@Controller
public class VeiculoController {
	
	//Veiculo Repository
	@Autowired
	private VeiculoRepository veiculos;
	
/*
 * ************************************||
 *  Render Pages
 *  Url: url mapping
 *  Html Files: file.html
 *  
 * ************************************||
 */
	// Login
	@GetMapping("/")
	public String login() {
		return "/login";
	}

	// Home
	@GetMapping("/home")
	public String home() {
		return "/home";
	}
	// User
	@GetMapping("/user")
	public String user() {
		return "/user";
	}
	@GetMapping("/header")
	public String header () {
		return "/_header";
	}

	// Form Cadastro
	@GetMapping("/form-veiculo")
	public String formVeiculo(Veiculo veiculo) {
		return "/form-cad-veiculo";
	}
	//Form Edit - Id
	@GetMapping("/pagina/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    Veiculo veiculo = veiculos.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

	    model.addAttribute("veiculo", veiculo);
	    return "pagina";
	}
	//Form Edit 
	@GetMapping("/pagina")
	public String showUpdate2 (Veiculo v) {
		return "/pagina";
	}
	//Detalhes
	@GetMapping("/detalhes-veiculo")
	public String showVeiculo(@PathVariable("id") long id, Model model) {
	    Veiculo v = veiculos.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

	    model.addAttribute("veiculo", v);
	    return "detalhes-veiculo";
	}
		
	//Form Proprietario
	@GetMapping("/form-proprietario")
	public String formProp() {
		return "/form-cad-properietario";
	}
	//Form Usuario
	@GetMapping("/form-usuario")
	public String cadUsuario() {
		return "/form-cad-usuario";
	}

/*
 * ********************************************
 *  CRUD OPERATIONS
 *  Create Read Update Delete
 *  
 * ********************************************
 */
	
	// Lista Veiculos
	@GetMapping("/veiculos")
	public String getAllVeiculos(Model model) {
		List<Veiculo> lst = veiculos.findAll();
		model.addAttribute("veiculos", lst);
		return "/list-veiculos";
	}

	// Save / Update Veiculo
	@PostMapping("/save-veiculo")
	public String addVeiculo(@Valid Veiculo veiculo) {
		veiculos.save(veiculo);
		return "redirect:/veiculos";
	}
	
	//Delete Veiculo
	@RequestMapping("/delete-veiculo/{id}")
	public String deletarVeiculo (@PathVariable ("id") long id) {
		Veiculo veiculo = veiculos.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		veiculos.delete(veiculo);
		return "redirect:/veiculos";
	}
	
}

package com.sgveiculos.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sgveiculos.model.Proprietario;
import com.sgveiculos.model.Veiculo;
import com.sgveiculos.repository.ProprietarioRepository;
import com.sgveiculos.repository.VeiculoRepository;
import com.sgveiculos.repository.VeiculosPgRepository;


/**Project: sgveiculos
 * File: VeiculoController.java
 * @author jaime Des
 * Em 17-05-2020 **/

@Controller
public class VeiculoController {
	
	/*
	 *  Repositories
	 */
	@Autowired
	private VeiculoRepository veiculos;
	@Autowired
	private ProprietarioRepository repository;
	@Autowired
	private VeiculosPgRepository pgRep;
	
/*
 * ************************************||
 *  Render Pages
 *  Url: url mapping
 *  Html Files: file.html
 *  
 * ************************************||
 */
	//User
	@GetMapping("/")
	public String login1 () {
		return "user";
	}
	// User
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	@GetMapping("/info")
	public String info() {
		return "info";
	}
	//Login
	@GetMapping("/login")
	public String login () {
		return "login";
	}
	// Form Veículo
	@GetMapping("/form-veiculo")
	public String formVeiculo(Veiculo veiculo) {
		return "form-cad-veiculo";
	}
	// Form Proprietario
	@GetMapping("/form-proprietario")
	public String formProp() {
		return "form-cad-properietario";
	}
	// Form Usuario
	@GetMapping("/form-usuario")
	public String cadUsuario() {
		return "form-cad-usuario";
	}
	// Form Edit - Id
	@GetMapping("/pagina/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		//Consulta Simples por ID
		Veiculo veiculo = veiculos.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		//List de Proprietario p campo Select
		List<Proprietario> lst = repository.findAllOrder();
		
		//Renderiza o Veiculo por ID
		model.addAttribute("veiculo", veiculo);
		//Renderiza a Lista de Proprietarios
		model.addAttribute("lst", lst); //List de Proprietario
		return "pagina";
	}
	/*
	 *  Metodo que pega a lista de proprietario 
	 *  em um select HTML
	 */
	// Form Edit Proprietario
	@GetMapping("/edit-prop/{id}")
	public String showUpdateFormP(@PathVariable("id") long id, Model model) {
		//Busca Proprietario por Id
		Proprietario p = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		//Renderiza
		model.addAttribute("proprietario", p);
		return "form-edit-prop";
	}
	// Detalhes
	@GetMapping("/detalhes-veiculo/{id}")
	public String showVeiculo(@PathVariable("id") long id, Model model) {
		Veiculo v = veiculos.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("veiculo", v);
		return "detalhes-veiculo";
	}
/*
 * ********************************************
 *  CRUD OPERATIONS
 *  Create Read Update Delete
 *  
 * ********************************************
 */	
	// Lista Veiculos ñ paginada
//	@GetMapping("/veiculos")
//	public String getAllVeiculos(Model model) {
//		List<Veiculo> lst = veiculos.findAll();
//		model.addAttribute("veiculos", lst);
//		return "/list-veiculos";
//	}
	// Lista Paginada
	@GetMapping("/list-veiculos")
	public String ListOrder (@PageableDefault (size = 10, sort = "id") Pageable pg, Model model) {
		//Paginação
		Page<Veiculo> page = pgRep.findAll(pg);
		//Ordenação
		List<Sort.Order> lstSort = page.getSort().stream().collect(Collectors.toList());
		if (lstSort.size() > 0) {
			Sort.Order order = lstSort.get(0);
			model.addAttribute("sortProperty", order.getProperty());
			model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
		}
		model.addAttribute("page", page );
		return "list-veiculos";
	}
	// Lista Proprietarios - ñ paginada
	@GetMapping("/proprietarios")
	public String getProprietarios(Model model) {
		//Lista proprietarios
		List<Proprietario> lst = repository.findAllOrder();
		//Renderiza a lista p View
		model.addAttribute("proprietarios", lst);
		return "list-proprietarios";
	}
	//Buscar por Nome
	@PostMapping("/buscar")
	public ModelAndView buscar (@RequestParam("nome") String nome) {
		ModelAndView model = new ModelAndView("list-proprietarios");
		model.addObject("proprietarios",repository.findByNome(nome));
		model.addObject("proprietarioobj", new Proprietario());
		return model;
	}
	
	// Save / Update Veiculo
	@PostMapping("/save-veiculo")
	public String addVeiculo(@Valid Veiculo veiculo) {
		veiculos.save(veiculo);
		return "redirect:/list-veiculos";
	}
	// save / Update Proprietario
	@PostMapping("/save-proprietario")
	public String addProprietario(@Valid Proprietario p) {
		repository.save(p);
		return "redirect:/proprietarios";
	}

	// Delete Veiculo
	@RequestMapping("/delete-veiculo/{id}") public String deletarVeiculo(@PathVariable("id") long id) {
		Veiculo veiculo = veiculos.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		veiculos.delete(veiculo);
		return "redirect:/list-veiculos";
	}
}

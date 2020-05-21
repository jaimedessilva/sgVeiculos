package com.sgveiculos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgveiculos.model.Proprietario;
import com.sgveiculos.model.Veiculo;
import com.sgveiculos.repository.ProprietarioRepository;
import com.sgveiculos.repository.VeiculoRepository;


/**Project: sgveiculos
 * File: VeiculoController.java
 * @author jaime
 * Em 17-05-2020 **/

@RestController
@RequestMapping(value="/api/veiculos")
public class VeiculoRestController {

	@Autowired
	private VeiculoRepository veiculos;
	@Autowired
	private ProprietarioRepository pRep;

	/*
	 * Construct
	 */
	public VeiculoRestController(VeiculoRepository veiculos) {
		this.veiculos = veiculos;
	}

	// GET PROPRIETARIOS
	@GetMapping("/p")
	public List<Proprietario> getAllProp() {
		return pRep.findAll();
	}

	// GET VEICULOS
	@RequestMapping("/v")
	public List<?> getAll() {
		return (List<?>) veiculos.findAll();
	}

	// GET VEICULOS ORDER
	@GetMapping("/order")
	public List<?> getAllOrder() {
		return veiculos.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	// GET PAGING
	@RequestMapping("/paging")
	public List<Veiculo> getAllpag() {

		int page = 0;
		int size = 10;
		String sortBy = "id";

		Pageable pg = PageRequest.of(page, size, Sort.by(sortBy));

		Page<Veiculo> pageResult = veiculos.findAll(pg);
		if (pageResult.hasContent()) {
			return pageResult.getContent();
		} else {
			return new ArrayList<Veiculo>();
		}
	}

	// GET/ID
	@GetMapping(path = { "/{id}" })
	public Optional<Veiculo> findById(@PathVariable long id) {
		return veiculos.findById(id);
	}

	// POST
	@PostMapping
	public Veiculo salvar(@RequestBody Veiculo v) {
		return veiculos.save(v);
	}

	// POST PROPRIETARIO
	@PostMapping("/add")
	public Proprietario salvarProp(@RequestBody Proprietario p) {
		return pRep.save(p);
	}

	// PUT
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable("id") long id, @RequestBody Veiculo v) {
		return veiculos.findById(id).map(record -> {
			record.setFabricante(v.getFabricante());
			record.setModelo(v.getModelo());
			record.setAnoFab(v.getAnoFab());
			record.setAnoMod(v.getAnoMod());
			record.setValor(v.getValor());
			record.setPlaca(v.getPlaca());
			Veiculo updated = veiculos.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());

	}

	// DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		veiculos.deleteById(id);
	}

}

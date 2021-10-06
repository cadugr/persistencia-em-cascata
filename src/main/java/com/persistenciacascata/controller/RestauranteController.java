package com.persistenciacascata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.persistenciacascata.model.Restaurante;
import com.persistenciacascata.repository.RestauranteRepository;
import com.persistenciacascata.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante cadastrar (@RequestBody Restaurante restaurante) {
		return restauranteService.cadastrar(restaurante);
	}
	
	@GetMapping
	public List<Restaurante> listar () {
		return restauranteRepository.findAll();
	}

}

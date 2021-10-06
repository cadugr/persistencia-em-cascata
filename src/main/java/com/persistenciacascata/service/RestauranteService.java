package com.persistenciacascata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistenciacascata.model.Restaurante;
import com.persistenciacascata.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Transactional
	public Restaurante cadastrar (Restaurante restaurante) {
		restaurante.addContatos(restaurante);	
		restaurante.addEnderecos(restaurante);
		return restauranteRepository.save(restaurante);
	}

}

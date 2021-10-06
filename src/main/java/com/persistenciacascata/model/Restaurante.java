package com.persistenciacascata.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(columnDefinition = "datetime")
	private OffsetDateTime dataCadastro;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(columnDefinition = "datetime")
	private OffsetDateTime dataAtualizacao;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	private List<Contato> contatos;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	
	public void addContatos(Restaurante restaurante) {
		for(Contato contato: restaurante.getContatos()) {
			contato.setRestaurante(restaurante);	
		}		
	}
	
	public void addEnderecos(Restaurante restaurante) {
		for(Endereco endereco: restaurante.getEnderecos()) {
			endereco.setRestaurante(restaurante);	
		}		
	}
	

}

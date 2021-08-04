package br.com.paulo.jupiter.model;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class ProdutoModel {
	private Long id;
	private String nome;
	private BigDecimal valor;
	
	public ProdutoModel(String nome, BigDecimal valor) {
		this.id = new SplittableRandom().nextLong(1, 100);
		this.nome = nome;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}

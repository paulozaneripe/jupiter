package br.com.paulo.jupiter.model;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class ItemCarrinhoModel {
	private Long id;
	private ProdutoModel produto;
	private Integer qtd;
	
	public ItemCarrinhoModel(ProdutoModel produto, int qtd) {
		this.id = new SplittableRandom().nextLong(1, 100);
		this.produto = produto;
		this.qtd = qtd;
	}

	public Long getId() {
		return id;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorTotal() {
		return produto.getValor().multiply(BigDecimal.valueOf(getQtd()));
	}
}

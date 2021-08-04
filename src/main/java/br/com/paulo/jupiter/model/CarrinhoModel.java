package br.com.paulo.jupiter.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class CarrinhoModel {
	private Long id;
	private List<ItemCarrinhoModel> itens;
	private EnumStatusCarrinho status;
	
	public CarrinhoModel() {
		this.id = new SplittableRandom().nextLong(1, 100);
		this.itens = new ArrayList<>();
		this.status = EnumStatusCarrinho.ANDAMENTO;
	}
	
	public Long getId() {
		return id;
	}

	public List<ItemCarrinhoModel> getItens() {
		return itens;
	}
	
	public List<ItemCarrinhoModel> addProduto(ProdutoModel produto, int qtd) {
		if(status.equals(EnumStatusCarrinho.ANDAMENTO)) {
			if(qtd > 0) {
				ItemCarrinhoModel itemCarrinho = new ItemCarrinhoModel(produto, qtd);
				itens.add(itemCarrinho);
				return itens;
			}
			throw new RuntimeException("Quantidade irregular!");
		}
		
		throw new RuntimeException("Carrinho finalizado");
	}

	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		for(ItemCarrinhoModel item : itens) {
			valorTotal = valorTotal.add(item.getValorTotal());
		}
		
		return valorTotal;
	}
	
	public void finalizar() {
		status = EnumStatusCarrinho.FINALIZADO;
	}
}

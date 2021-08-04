package br.com.paulo.jupiter.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulo.jupiter.model.CarrinhoModel;
import br.com.paulo.jupiter.model.ItemCarrinhoModel;
import br.com.paulo.jupiter.model.ProdutoModel;

@RestController
public class CarrinhoController {
	
	@GetMapping("/inicia-carrinho-com-produto")
	public List<ItemCarrinhoModel> carrinhoModel(@RequestParam(value = "produto") String produto, @RequestParam(value = "qtd") Integer qtd) {
		ProdutoModel p = new ProdutoModel(produto,BigDecimal.valueOf(4));
		return new CarrinhoModel().addProduto(p, qtd);
	}
	
	@GetMapping("/inicia-carrinho")
	public CarrinhoModel carrinhoModel2() {
		return new CarrinhoModel();
	}
	
	@GetMapping("/inicia-carrinho-cheio")
	public CarrinhoModel carrinhoModel3() {
		ProdutoModel p = new ProdutoModel("Café", BigDecimal.valueOf(5));
		ProdutoModel p2 = new ProdutoModel("Arroz", BigDecimal.valueOf(7));
		ProdutoModel p3 = new ProdutoModel("Feijão", BigDecimal.valueOf(8));
		
		CarrinhoModel carrinho = new CarrinhoModel();
		carrinho.addProduto(p, 5);
		carrinho.addProduto(p2, 10);
		carrinho.addProduto(p3, 2);
		
		return carrinho;
	}
}

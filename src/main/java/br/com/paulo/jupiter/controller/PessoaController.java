package br.com.paulo.jupiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulo.jupiter.model.PessoaFisicaModel;
import br.com.paulo.jupiter.model.PessoaJuridicaModel;

@RestController
public class PessoaController {
	
	@GetMapping("/valida-cpf")
	public Boolean pessoaFisica(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf).getValidacaoDocumento();
	}
	
	@GetMapping("/gerar-cpf-formatado")
	public String pessoaFisica2(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf).getDocumentoForma();
	}
	
	@GetMapping("/gerar-pessoa-fisica")
	public PessoaFisicaModel pessoaFisica3(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf);
	}
	
	@GetMapping("/valida-cnpj")
	public Boolean pessoaJuridica(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj).getValidacaoDocumento();
	}
	
	@GetMapping("/gerar-cnpj-formatado")
	public String pessoaJuridica2(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj).getDocumentoForma();
	}
	
	@GetMapping("/gerar-pessoa-juridica")
	public PessoaJuridicaModel pessoaJuridica3(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj);
	}
}

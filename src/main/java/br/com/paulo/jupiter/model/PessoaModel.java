package br.com.paulo.jupiter.model;

public abstract class PessoaModel {
	private String documento;

	public PessoaModel(String documento) {
		this.documento = documento;
	}
	
	public abstract Boolean getValidacaoDocumento();
	public abstract String getDocumentoGerado();
	public abstract String getDocumentoForma();

	public String getDocumento() {
		return documento;
	}
	
	public abstract Integer[] gerarDocUltimosDigitos(String documento);
}

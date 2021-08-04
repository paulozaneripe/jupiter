package br.com.paulo.jupiter.model;

import java.util.SplittableRandom;

public class PessoaFisicaModel extends PessoaModel {

	public PessoaFisicaModel(String documento) {
		super(documento);
	}

	@Override
	public Boolean getValidacaoDocumento() {
		if(getDocumento().length() == 11) {
			Integer penultimoDigito = Integer.parseInt(getDocumento().charAt(9) + "");
			Integer ultimoDigito = Integer.parseInt(getDocumento().charAt(10) + "");
			Integer ultimosDigitos[] = gerarDocUltimosDigitos(getDocumento());
			
			if(ultimosDigitos[0] == penultimoDigito) {
				if(ultimosDigitos[1] == ultimoDigito) {
					return true;
				}
			}
			
			return false;
		}
			
		throw new RuntimeException("Documento inválido");
	}

	@Override
	public String getDocumentoGerado() {
		var random = new SplittableRandom();
		String cpf = "";
		
		for(int i = 0; i < 9; i++) {
			cpf += random.nextInt(0, 10);
		}
		
		Integer[] ultimosDigitos = gerarDocUltimosDigitos(cpf);
		
		cpf += ultimosDigitos[0];
		cpf += ultimosDigitos[1];
		
		return cpf;
	}

	@Override
	public String getDocumentoForma() {
		String cpfFormatado = "";
		
		for (int i = 0; i < 11; i++) {
			if (i < 3) {
				cpfFormatado += getDocumento().charAt(i);
			} else if (i == 3) {
				cpfFormatado += ".";
				cpfFormatado += getDocumento().charAt(i);
			} else if (i < 6) {
				cpfFormatado += getDocumento().charAt(i);
			} else if (i == 6) {
				cpfFormatado += ".";
				cpfFormatado += getDocumento().charAt(i);
			} else if (i < 9) {
				cpfFormatado += getDocumento().charAt(i);
			} else if (i == 9) {
				cpfFormatado += "-";
				cpfFormatado += getDocumento().charAt(i);
			} else {
				cpfFormatado += getDocumento().charAt(i);
			}
		}
		
		return cpfFormatado;
	}

	@Override
	public Integer[] gerarDocUltimosDigitos(String documento) {
		Integer[] ultimosDigitos = {0, 0};
		Integer total = 0;
		
		for(int i = 0; i < 9; i++) {
			total += Integer.parseInt(documento.charAt(i) + "") * (i + 1);
		}
		
		ultimosDigitos[0] = total % 11;
		total = 0;
		
		String doc = documento + ultimosDigitos[0];
		
		for(int i = 0; i < 10; i++) {
			total += Integer.parseInt(doc.charAt(i) + "") * i;
		}
		
		ultimosDigitos[1] = total % 11;
		
		return ultimosDigitos;
	}

}

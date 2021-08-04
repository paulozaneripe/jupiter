package br.com.paulo.jupiter.model;

import java.util.SplittableRandom;

public class PessoaJuridicaModel extends PessoaModel {

	public PessoaJuridicaModel(String documento) {
		super(documento);
	}

	@Override
	public Boolean getValidacaoDocumento() {
		if(getDocumento().length() == 14) {
			Integer penultimoDigito = Integer.parseInt(getDocumento().charAt(12) + "");
			Integer ultimoDigito = Integer.parseInt(getDocumento().charAt(13) + "");
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
		String cnpj = "";
		Integer total = 0;
		
		for(int i = 0; i < 12; i++) {
			if(i > 7 && i < 11) {
				cnpj += 0;
			} else {
				cnpj += random.nextInt(1, 10);
			}
		}
		
		for(int i = 0; i < 12; i++) {
			if(i < 4) {
				total += Integer.parseInt(cnpj.charAt(i) + "") * (5 - i);
			} else {
				total += Integer.parseInt(cnpj.charAt(i) + "") * (13 - i);
			}
		}
		
		total = total % 11;
		if(total < 2) {
			cnpj += 0;
		} else {
			cnpj += (11 - total);
		}
		total = 0;
		
		for(int i = 0; i < 13; i++) {
			if(i < 5) {
				total += Integer.parseInt(cnpj.charAt(i) + "") * (6 - i);
			} else {
				total += Integer.parseInt(cnpj.charAt(i) + "") * (14 - i);
			}
		}
		
		total = total % 11;
		if(total < 2) {
			cnpj += 0;
		} else {
			cnpj += (11 - total);
		}
		
		return cnpj;
	}

	@Override
	public String getDocumentoForma() {
		String cnpjFormatado = "";
		
		for (int i = 0; i < 14; i++) {
			if (i < 2) {
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i == 2) {
				cnpjFormatado += ".";
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i < 5) {
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i == 5) {
				cnpjFormatado += ".";
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i < 8) {
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i == 8) {
				cnpjFormatado += "/";
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i < 11) {
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i < 12) {
				cnpjFormatado += getDocumento().charAt(i);
			} else if (i == 12) {
				cnpjFormatado += "-";
				cnpjFormatado += getDocumento().charAt(i);
			} else {
				cnpjFormatado += getDocumento().charAt(i);
			}
		}
		
		return cnpjFormatado;
	}

	@Override
	public Integer[] gerarDocUltimosDigitos(String documento) {
		Integer[] ultimosDigitos = {0, 0};
		Integer total = 0;
		
		for(int i = 0; i < 12; i++) {
			if(i < 4) {
				total += Integer.parseInt(getDocumento().charAt(i) + "") * (i + 6);
			} else {
				total += Integer.parseInt(getDocumento().charAt(i) + "") * (i - 2);
			}
			
		}
		
		ultimosDigitos[0] = total % 11;
		total = 0;
		
		String doc = documento + (ultimosDigitos[0].equals(10) ? 0 : ultimosDigitos[0]);
		
		for(int i = 0; i < 13; i++) {
			if(i < 5) {
				total += Integer.parseInt(doc.charAt(i) + "") * (i + 5);
			} else {
				total += Integer.parseInt(doc.charAt(i) + "") * (i - 3);
			}
		}
		
		ultimosDigitos[1] = total % 11;
		ultimosDigitos[1] = (ultimosDigitos[1].equals(10) ? 0 : ultimosDigitos[1]);
		
		return ultimosDigitos;
	}

}

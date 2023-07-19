package Estoque;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
 
	private String Complemento;
	private String Logradouro;
	
	public Endereco() {
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
}

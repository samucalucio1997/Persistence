package logis;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CLR")
public class ClienteR {
	  @javax.persistence.Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long Id;
	  
	  private String nome;
	  
	  private String Protocolo;
	  
	  public ClienteR() {

	}
	  

	public ClienteR(String nome, String protocolo) {
		super();
		this.nome = nome;
		this.Protocolo = protocolo;
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProtocolo() {
		return Protocolo;
	}

	public void setProtocolo(String protocolo) {
		Protocolo = protocolo;
	}
	  
	  
}

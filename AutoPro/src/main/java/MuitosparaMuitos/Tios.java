package MuitosparaMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Tios {
  @javax.persistence.Id	
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @JoinColumn(nullable = false)
  private String nome;
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<Sobrinhos> sobrinhos=new ArrayList<>();
	
  public Tios() {
	}
  
public Tios(String nome) {
	this.nome = nome;
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

public List<Sobrinhos> getSobrinhos() {
	return sobrinhos;
}

public void setSobrinhos(List<Sobrinhos> sobrinhos) {
	this.sobrinhos = sobrinhos;
}
  
}

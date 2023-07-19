package MuitosparaMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
@Entity
public class Sobrinhos {
   @javax.persistence.Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
   
   @JoinColumn(nullable = false)
   private String nome;
   
   @ManyToMany(mappedBy = "sobrinhos")
   private List<Tios> tios = new ArrayList<>();
	 
   public Sobrinhos() {

}

public Sobrinhos(String nome) {
	super();
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

public List<Tios> getTios() {
	return tios;
}

public void setTios(List<Tios> tios) {
	this.tios = tios;
}
 
   
}

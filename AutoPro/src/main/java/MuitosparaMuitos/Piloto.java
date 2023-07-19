package MuitosparaMuitos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
@Entity
public class Piloto {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nome;
	@ManyToMany(cascade =  CascadeType.PERSIST)
	private List<Corrida> corridas;
	
	public Piloto() {

	}

	public Piloto(String nome) {
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

	public List<Corrida> getCorridas() {
		if(corridas==null) {
			corridas = new ArrayList<>();
		}
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}
	
}

package logis;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contratante {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String protocol;
	
	@OneToMany(mappedBy = "contratante", fetch = FetchType.LAZY)
	private List<ItensTransporte> itens;
	
	
	
	public Contratante(String protocol) {
		this.protocol = protocol;
	}

	public Contratante() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public List<ItensTransporte> getItens() {
		return itens;
	}

	public void setItens(List<ItensTransporte> itens) {
		this.itens = itens;
	}
	
	
}

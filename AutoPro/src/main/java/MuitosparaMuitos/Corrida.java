package MuitosparaMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   
    private String nome;
     
    @ManyToMany(mappedBy = "corridas", cascade = CascadeType.PERSIST)
    private List<Piloto> pilotos;
    
    public Corrida() {

	}

	public Corrida(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Piloto> getPilotos() {
		if(pilotos==null) {
			pilotos = new ArrayList<>();		
		}
		return pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
    
    public void AdicionarPilotos(Piloto p) {
    	if(p!=null && !getPilotos().contains(p)) {
    		getPilotos().add(p);	
    		if(!p.getCorridas().contains(this)) {    			
    			p.getCorridas().add(this);    		
    		}
    	}
    	
    }
}

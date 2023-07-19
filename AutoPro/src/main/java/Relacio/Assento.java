package Relacio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assentos")
public class Assento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="ID")
    private Long ID;
	
	private String name;
	@OneToOne(mappedBy = "assento",cascade = CascadeType.ALL)
	private Cliente cli;

	public Assento() {
		
	}

	public Assento(String name) {
		this.name = name;
	} 
	
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

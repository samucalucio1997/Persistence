package Relacio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
@Table(name="clientes")
public class Cliente {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="Id")
     private Long Id;
	 
	private String name;
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="assento_id", unique=true, nullable = false)
	 private Assento assento;
	 
	public Cliente() {
		
	}

	public Cliente(String name, Assento assento) {
		super();
		this.name = name;
		this.assento = assento;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}


	
	 
}

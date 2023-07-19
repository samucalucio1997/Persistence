package logis;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
@Entity
public class ItensTransporte {
     @javax.persistence.Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Id;
	 
     private String coisa;
     
     @ManyToOne(fetch = FetchType.EAGER)
     private Contratante contratante;
     
     @ManyToOne(fetch = FetchType.EAGER)
     private RotaTransporte rota;
     

	private int qtd;

	 public ItensTransporte() {
		 // TODO Auto-generated constructor stub
	 }
	 
	
	 public ItensTransporte(String coisa, Contratante contratante, RotaTransporte rota, int qtd) {
		this.coisa = coisa;
		this.contratante = contratante;
		this.rota = rota;
		this.qtd = qtd;
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getCoisa() {
		return coisa;
	}

	public void setCoisa(String coisa) {
		this.coisa = coisa;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public RotaTransporte getRota() {
		return rota;
	}
	
	
	public void setRota(RotaTransporte rota) {
		this.rota = rota;
	}
	 
}

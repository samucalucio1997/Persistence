package logis;

import javax.persistence.OneToOne;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RotaTransporte {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     
     private String Rota;
     
     private boolean baixado;
     
     @OneToOne
     private Contratante contratante;
     
     
     
     public RotaTransporte() {
    	 
     }
     
     public RotaTransporte(String rota, Contratante contratante) {
    	 super();
    	 Rota = rota;
    	 this.contratante = contratante;
     }
     
     public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRota() {
		return Rota;
	}

	public void setRota(String rota) {
		Rota = rota;
	}

	public boolean isBaixado() {
		return baixado;
	}

	public void setBaixado(boolean baixado) {
		this.baixado = baixado;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

     

}

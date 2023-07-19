package logis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CLE")
public class ClienteE extends ClienteR {
        
	private Double BenficioCre;
	
	public ClienteE() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ClienteE(String nome, String protocolo,Double benficioCre) {
		super(nome,protocolo);
		BenficioCre = benficioCre;
	}


	public Double getBenficioCre() {
		return BenficioCre;
	}

	public void setBenficioCre(Double benficioCre) {
		BenficioCre = benficioCre;
	}

	
}

package MuitosparaMuitos;



import java.util.List;

import Relacio.DAO;

public class TiTeste {
   public static void main(String[] args) {

       Corrida f = new Corrida("Superbike Goiânia-br");
       Corrida h  = new Corrida("Superbike Interlagos");
	   Piloto p1 = new Piloto("Fabio Bagna");
	   Piloto p2 = new Piloto("Alex Spargaro");
        
//	    f.AdicionarPilotos(p1);
//	    h.AdicionarPilotos(p2);
//	    h.AdicionarPilotos(p1);
	    
	    DAO<Corrida> d = new DAO<>(Corrida.class);
	    
	    List<Corrida> k = d.ConsultaP("ObterCorridas", "nome","Superbike Goiânia-br");
	    
	    for(Corrida pil:k) {
	    	System.out.println(pil.getNome());
	    	for(Piloto l:pil.getPilotos()) {
	    		System.out.println(l.getNome());
	    	}
	    }
	    
	    
 }
}

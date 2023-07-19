package Estoque;

import java.util.function.Function;

public class ProDAO extends DAO<Produto> {
  

public ProDAO(Class<Produto> Entidade) {
		super(Entidade);
	}

public double Desconto(double por,double pr) {  
	   Function<Double,Double> desc = (t) -> {
		   double a = pr;
		   double pre = a-(a*por)/100;
		   return pre;
	   };
	
	   return desc.apply(por);

   }

	
}

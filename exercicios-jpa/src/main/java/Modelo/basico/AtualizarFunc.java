package Modelo.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizarFunc {
   public static void main(String[] args) {
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
	   EntityManager en = emf.createEntityManager();
	   
	  en.getTransaction().begin();
	  
	  Censo obj = en.find(Censo.class, 2L);
	  obj.setNacionalidade("checheno");
	  //obj.setSalario((float) (obj.getSalario()-0.2*(obj.getSalario())));
	  
	  //en.merge(obj);
	  
	  en.getTransaction().commit();
	  
	  System.out.println(en.find(Censo.class, 2L).getSalario());
	  System.out.println(en.find(Censo.class, 2L).getNacionalidade());
	   
		
    }
}

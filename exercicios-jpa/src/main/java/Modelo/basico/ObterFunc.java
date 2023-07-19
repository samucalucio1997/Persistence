package Modelo.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterFunc {
    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager en = emf.createEntityManager();
		
		Censo func = en.find(Censo.class, 2L);
		System.out.println(func.getNacionalidade());
    }
}

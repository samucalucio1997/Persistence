package Modelo.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovFuncionario {
        public static void main(String[] args) {
        	
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
			EntityManager en = emf.createEntityManager();
			Float d = new Float(7325.45);
			Censo fun = new Censo("italiano","Romero",d);
			
			en.getTransaction().begin();	
			en.persist(fun);
			en.getTransaction().commit();
			
		}
}

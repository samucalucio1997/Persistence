package Modelo.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Remover {
      public static void main(String[] args) {
    	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo-test");
     	 EntityManager em = emf.createEntityManager();
     	 
     	 Pretest cadastrado = em.find(Pretest.class,10L);
     	 
     	 if(cadastrado != null) {
     		 em.getTransaction().begin();
     		 em.remove(cadastrado);
     		 em.getTransaction().commit();
     	 }
	}
}

package Modelo.Teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ConsltaCadastrados {
     public static void main(String[] args) {
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo-test");
    	 EntityManager em = emf.createEntityManager();
    	 
    	 TypedQuery <Pretest> cadastrados = em.createQuery("select u from Pretest u",Pretest.class).setMaxResults(17);
    	 
    	 List <Pretest> cad = cadastrados.getResultList();
    	 
    	 for(Pretest c:cad) {
    		 System.out.println(c.getId()+" "+c.getCpf()+" "+c.getNome());
    	 }
	}
}

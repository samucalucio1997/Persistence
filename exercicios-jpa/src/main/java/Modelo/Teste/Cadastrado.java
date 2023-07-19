package Modelo.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Cadastrado {
   public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo-test");
	EntityManager em = emf.createEntityManager();
	
	Pretest novo = new Pretest("045688847-77","Agnaldo da Silva");
	
	em.getTransaction().begin();
	em.persist(novo);
	em.getTransaction().commit();
	
	
	
	
  }
} 

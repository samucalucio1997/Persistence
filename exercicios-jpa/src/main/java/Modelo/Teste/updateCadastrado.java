package Modelo.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class updateCadastrado {
  public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Modelo-test");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	Pretest cadastro = em.find(Pretest.class, 10L);
	cadastro.setNome("Otacílio Jorge");//modify without merge(obj T) because cadastro is how maneged object!!!
	em.getTransaction().commit();
  }
}

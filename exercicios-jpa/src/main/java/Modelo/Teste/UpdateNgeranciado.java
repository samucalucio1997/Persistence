package Modelo.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateNgeranciado {
   public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo-test");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	                     //Table or Class, Id
	Pretest Human = em.find(Pretest.class, 10L);
	em.detach(Human);// modify the status of instance(Human) for unmanaged
	em.merge(Human);// so, for update is needed call ".merge(object t)" method
	em.getTransaction().commit();
	
}
}

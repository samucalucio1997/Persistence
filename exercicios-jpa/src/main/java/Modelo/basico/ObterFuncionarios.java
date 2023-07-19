package Modelo.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




public class ObterFuncionarios {
    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager en = emf.createEntityManager();
		
		TypedQuery <Censo> func = en.createQuery("select u from Censo u", Censo.class).setMaxResults(4);
		
		List <Censo> funcionarios = func.getResultList();
		
		for(Censo funcionario:funcionarios) {
			System.out.println("Nacionalidade:" + funcionario.getNacionalidade() + 
					" Nome:" + funcionario.getNome());
		}
	}
}

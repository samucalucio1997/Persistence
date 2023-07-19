package Relacio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO extends DAO<Object>{
	 private static EntityManagerFactory emf;
	 private EntityManager em;
	 private Cliente cliente;
	 private Assento ass;

	 static {
		 try {
			 emf = Persistence.createEntityManagerFactory("AutoPro");
		 }catch (Exception e){
			 emf.close();
		 }
	 }
	 
	public ClienteDAO() {
		em=emf.createEntityManager();
	}
	

	public ClienteDAO(Cliente cliente, Assento ass) {
		super();
		this.cliente = cliente;
		this.ass = ass;
		em=emf.createEntityManager();
	}




	
	public DAO<Object> Inserir(Cliente Entidade) {
		try {
			em.getTransaction().begin();
			if(Entidade.getId()==null) {
				em.persist(Entidade);				
			}else {
				em.merge(Entidade);
			}
			em.getTransaction().commit();
			return this;
		}catch (Exception e){
			
			return null;
		}
		
	}

	@Override
	public Object BuscabyID(Long Id) {
		return super.BuscabyID(Id);
	}
	
	public DAO<Object> Inserir(Assento Entidade) {
           try {
        	   em.getTransaction().begin();
   			if(em.find(Entidade.getClass(), cliente.getId())==null) {
   				em.persist(Entidade);				
   			}else {
   				em.merge(Entidade);
   			}
   			em.getTransaction().commit();
           }finally {
        	   
           }
		
		
		return null;
	}
	

}

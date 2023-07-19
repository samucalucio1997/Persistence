package Relacio;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class DAO<t> {
	
 private static EntityManagerFactory emf;
 private EntityManager em;
 private Class<t> entidade;
 
static {
	
	emf=Persistence.createEntityManagerFactory("AutoPro");
}
 
public DAO() {
	this.em = emf.createEntityManager();
}

public DAO(Class<t> Entidade){
	this.entidade=Entidade;
	this.em = emf.createEntityManager();	
}



 
public DAO<t> Inserir(t Entidade) {
		     if(Entidade!=null) {
		    	 em.getTransaction().begin();
		    	 em.persist(Entidade);
		    	 em.getTransaction().commit();
		    	 return this;		    	 
		     }
		     return this; 
		        
		     
}

public DAO<t> Atualizar(Long Id,String ass) {
			
			em.getTransaction().begin();
			Cliente obj = em.find(Cliente.class, Id);
			em.getTransaction().commit();
			em.close();
			obj.getAssento().setName(ass);
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			em.close();
			return this;
			
}

//public void Atualizar(Long Id, Assento ass){
//	if(em.find(ass.getClass(), Id)!=null) {
//	    this.em.getTransaction().begin();
//		this.em.detach(ass);
//		this.em.merge(ass);
//		this.em.getTransaction().commit();
//	    
//	}else {
//		
//	}
//	
//}

public DAO<t> Remover(t Entidade,Long Id) {
	try {
		
			
			em.getTransaction().begin();
			
		    em.remove(em.find(Entidade.getClass(), Id));
		    
			em.getTransaction().commit();
			return this;
		
			
	}catch(Exception e) {
		return null;
	}
}

public List<t> Consulta(){
	String jpql="select u from " + entidade.getName() + " u";
	@SuppressWarnings("unchecked")
	TypedQuery<t> query = (TypedQuery<t>) em.createQuery(jpql);
	return query.getResultList();
}

public List<t> Consulta(int limit, int qtgrup){
	String jpql="select u from " + entidade.getName() + " u";
	@SuppressWarnings("unchecked")
	TypedQuery<t> query = (TypedQuery<t>) em.createQuery(jpql).setMaxResults(limit);
	return query.setFirstResult(qtgrup).getResultList();
}

public t BuscabyID(Long Id) {
	return em.find(entidade, Id);
}
public List<t> ConsultaP(String nomedaconsulta, Object...objects){
	TypedQuery<t> query = em.createNamedQuery(nomedaconsulta, entidade);
	   for(int c=0;c<objects.length;c+=2) {
		   query.setParameter(objects[c].toString(), objects[c+1]);
	   }
	   return query.getResultList();
}



}

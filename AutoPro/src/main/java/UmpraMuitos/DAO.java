package UmpraMuitos;



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

public DAO<t> fecharT(){
			this.em.getTransaction().commit();
			return this;
}

public DAO<t> abrirT(){
	this.em.getTransaction().begin();
	return this;
}

public void Fechar(){
	this.em.close();
}

 
public DAO<t> Inserir(t Entidade) {
		 
			 em.getTransaction().begin();
			 em.persist(Entidade);
			 em.getTransaction().commit();
	return this;
}

public DAO<t> Atualizar(Long Id,t novo) {
			if(em.find(novo.getClass(), Id)!=null) {
			em.getTransaction().begin();
//			novo.setName(novo.getName());
            em.merge(novo);
			em.getTransaction().commit();
			return this;
			}else {
				
				return null;
			}
}

public void atualizar(Long Id, t ass){
	if(em.find(ass.getClass(), Id)!=null) {
	    this.em.getTransaction().begin();
		this.em.detach(ass);
		this.em.merge(ass);
		this.em.getTransaction().commit();
	    
	}else {
		
	}
	
}

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

public t BuscaID(Long Id) {
	return em.find(entidade, Id);
}

}

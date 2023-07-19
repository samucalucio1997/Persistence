package Modelo.DAO;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Dao<E extends IDBase> {
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> entidade;
    static {
    	try {
    		emf = Persistence.createEntityManagerFactory("Modelo-test");
    	} catch (Exception e) {
    		
    	}
    }
    
    public Dao(Class<E> entidade){
    	this.entidade=entidade;
    	em = emf.createEntityManager();
    }
    
    public Dao<E> abrirT(){
    	em.getTransaction().begin();
        return this; 
    }
    
    public Dao<E> FecharT(){
    	em.getTransaction().commit();
    	return this;
    }
    
    public Dao<E> Incluir(E produto){
    	this.abrirT();
    	em.persist(produto);
    	this.FecharT();
    	return this;
    }
    
    public E BucarbyId(Long id) {
    	 return em.find(this.entidade, id);
    }
    
    public void Remover(E entidade,Long Id){
    	
    	this.abrirT();
    	if(em.find(Produtos.class, Id)!=null) {
    		

    		em.remove(entidade);
    	}
    	this.FecharT();
    }
    
    public Dao<E> Update_Save(Long Id, E novo){
    	if(this.BucarbyId(Id)!=null) {
    		em.detach(novo);
    		this.abrirT();
    	    em.merge(novo);
    	    this.FecharT();
    	    return this;
    	}else {
    		return null;
    	}       	
    }
   
    public List<E> Listar(int limite, int tamdoGP){
    	if(entidade==null) {
    		throw new UnsupportedOperationException("Entidade nula.");
    	}
    	String jpql = "select e from "+ entidade.getName() +" e";
    	TypedQuery<E> query =em.createQuery(jpql, entidade).setMaxResults(limite);
    	query.setFirstResult(tamdoGP);
    	return query.getResultList();	
    }
   
    public List<E> Lista(){
    	if(entidade==null) {
    		throw new UnsupportedOperationException("Entidade nula.");
    	}
    	String jpql = "select u from " + entidade.getName() + " u";
    	TypedQuery<E> query = (TypedQuery<E>) em.createQuery(jpql);
    	return query.getResultList();
    }
    
    public void Fechar() {
    	em.close();
    }
 
}

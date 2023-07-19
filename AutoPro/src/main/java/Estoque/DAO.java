package Estoque;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;



public class DAO<t extends BaseID> {
	
 private static EntityManagerFactory emf;
 private EntityManager em;
 private Class<t> entidade;
 
static {
	
	emf=Persistence.createEntityManagerFactory("AutoPro");
}
 public DAO() {
    em =emf.createEntityManager();
}
 
public DAO(Class<t> Entidade){
	this.entidade=Entidade;
	em = emf.createEntityManager();
}
 
public Produto Inserir(Produto produto) {
		try {
			em.getTransaction().begin();
			if(produto.getId()==null) {
				em.persist(produto);				
			}else {
				produto = em.merge(produto);
			}
			em.getTransaction().commit();
		}finally{
			em.close();
		}	
		return produto;
}

public DAO<t> Atualizar(Long Id,Produto novo) {
	try {		
		if(em.find(novo.getClass(), Id)!=null) {
			em.close();
			novo.setNome(novo.getNome());
			novo.setPreco(novo.getPreco());
			em.getTransaction().begin();
            em.merge(novo);
			em.getTransaction().commit();
			return this;
		}else {
			return null;
		}
		
	}catch(Exception e) {
         return null;		
	}
}

public DAO<t> Remover(t Entidade,Long Id) {
	try {
		if(Entidade!=null) {
			Produto pro = em.find(Produto.class, Id);
			em.getTransaction().begin();
			em.remove(pro);
			em.getTransaction().commit();
			return this;
		}else {
			return null;
		}
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

public List<t> Coonsulta(int limit, int qtgrup){
	String jpql="select u from " + entidade.getName() + " u";
	
	TypedQuery<t> query = (TypedQuery<t>) em.createQuery(jpql).setMaxResults(limit);
	return query.setFirstResult(qtgrup).getResultList();
}

public t getbyId(Long ID) {
	return em.find(entidade, ID);
}

public Long getID(Produto Entidade) {
	String jpql="select "+ "id" +" from " + entidade.getName()
	+ " u where u.nome =" +"'"+Entidade.getNome()+"'";
	TypedQuery<Long> query =  (TypedQuery<Long>) em.createQuery(jpql);
	List<Long> f= query.getResultList();
	Long[] g = new Long[f.size()];
	for(int c=0;c<f.size();c++) {
		for(Long d:f) {
		    g[c]=d;
		}
	}
	return g[0];	
}

public Produto InserirT(Produto pro) {
	try {
		em.getTransaction().begin();
		if(getID(pro)==null) {
			em.persist(pro);
		}else {
			em.detach(pro);
			pro.setPreco(pro.getPreco());
			em.merge(pro);
		}
		em.getTransaction().commit();
	}finally {
		em.close();
	}
	return pro;	
}

public List<t> ConsultaP(String nomedaconsulta, Object...objects){
	TypedQuery<t> query = em.createNamedQuery(nomedaconsulta, entidade);
	   for(int c=0;c<objects.length;c+=2) {
		   query.setParameter(objects[c].toString(), objects[c+1]);
	   }
	   return query.getResultList();
}

public t Conxml(String nome, Object...objects ){
	NativeQuery<t> query =  (NativeQuery<t>) em.createNamedQuery(nome, entidade);
	 for(int c=0;c<objects.length;c+=2) {
		 query.setParameter(objects[c].toString(), objects[c+1]);
	 }
	 List<t> lista = query.getResultList();
	 return lista.isEmpty()?null:lista.get(0);
}

}

package Modelo.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Itens")
public class Produtos implements IDBase{
      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Column(name="Kod_nome")
      private String nome;

	@Column(name="Suporte_valor")
      private double preco;
	  
	  public Produtos() {
		  
	  }
	  public Produtos(String nome, double preco) {
		  super();
		  this.nome = nome;
		  this.preco = preco;
	  }
	 
	  public void setId(Long id) {
		  this.id = id;
	  }
	  public String getNome() {
		  return nome;
	  }
	  public void setNome(String nome) {
		  this.nome = nome;
	  }
	  public double getPreco() {
		  return preco;
	  }
	  public void setPreco(double preco) {
		  this.preco = preco;
	  }
	 @Override
	 public Long getId() {
		
		return null;
	}
      
      
}

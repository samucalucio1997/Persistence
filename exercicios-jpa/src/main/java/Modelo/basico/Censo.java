package Modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Censo {
	  @Id  
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      
      private String nacionalidade;
      private String nome;
      private float salario;
      
      public Censo() {
    	  
      }

      
      public Censo(String nacionalidade, String nome, float salario) {
		this.nacionalidade = nacionalidade;
		this.nome = nome;
		this.salario = salario;
	}

      
      public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
}

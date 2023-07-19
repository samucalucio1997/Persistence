package Estoque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Produto implements BaseID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
	private Long Id;
    @Column
	private double preco;
    @Column
    private String nome;
    
    public Produto() {}
    
    public Produto(double preco, String nome) {
		this.preco = preco;
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}

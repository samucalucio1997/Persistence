package UmpraMuitos;


import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import Estoque.Produto;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	  
	 private int qtd;
	 
	 private Double preco;

	 @ManyToOne(fetch = FetchType.EAGER)// o item de pedido traz consigo um produto por si só(ToOne->EAGER)
	 private Produto produto;
	 
	 @ManyToOne
	 @JoinTable(name="test")@JoinColumn(name = "ItemPedido_id" , referencedColumnName = "Id")
	 private Pedido pedidos;
	
	 public ItemPedido() {
		
	}
	 
	  
	 public ItemPedido(int qtd, Produto produto, Pedido pedidos) {
		this.qtd = qtd;
		this.produto = produto;
		this.pedidos = pedidos;
	}



	public Long getId() {
		 return Id;
	 }
	 
	 public void setId(Long id) {
		 this.Id = id;
	 }
	 
	 public int getQtd() {
		 return qtd;
	 }
	 
	 public void setQtd(int qtd) {
		 this.qtd = qtd;
	 }
	 
	 public Double getPreco() {
		 return preco;
	 }
	 
	 public void setPreco(Double preco) {
		 this.preco = preco;
	 }
	 
	 public Produto getProduto() {
		 return produto;
	 }
	 
	 public void setProduto(Produto produto) {
		 if(produto!=null && this.preco==null ) {
			 this.setPreco(produto.getPreco());
		 }
	 }
	 
	 public Pedido getPedidos() {
		 return pedidos;
	 }
	 
	 public void setPedidos(Pedido pedidos) {
		 this.pedidos = pedidos;
	 }
}

package UmpraMuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Date data;

	@OneToMany(mappedBy="pedidos" , fetch = FetchType.LAZY) // esse é o valor default de fetch (ToMany -> LAZY)
	private List<ItemPedido> item;
	
	public List<ItemPedido> getItem() {
		return item;
	}



	public void setItem(List<ItemPedido> item) {
		this.item = item;
	}



	public Pedido() {
		this(new Date());
	}
	
	
	
	public Pedido(Date data) {
		this.data = data;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}

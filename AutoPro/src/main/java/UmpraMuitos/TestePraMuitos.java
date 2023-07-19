package UmpraMuitos;

import Estoque.Produto;

public class TestePraMuitos {

	public static void main(String[] args) {
//		Pedido pedido=new Pedido();
//		Produto pro = new Produto(3465.90,"Maquina de lavar");
//		ItemPedido item = new ItemPedido(5,pro,pedido);
//		
//		DAO<Object> dao = new DAO<>();
//		
//		dao.Inserir(pro).Inserir(pedido).Inserir(item);		

		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.BuscaID(1L);
	    
		
		for(ItemPedido f:pedido.getItem()) {
			System.out.println(f.getProduto().getNome());
			System.out.println(f.getProduto().getPreco());
			System.out.println(f.getQtd());
		}
		dao.Fechar();
	}
}

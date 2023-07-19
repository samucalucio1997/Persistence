package Modelo.DAO;



public class NovoProduto extends Dao<Produtos>{

	public NovoProduto(Class<Produtos> Produtos) {
		super(Produtos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Dao<Produtos> Update_Save(Long Id, Produtos novo) {
				
				super.Update_Save(Id, novo);
	            
//				novo.setPreco();
				
				return super.abrirT();
	}
  

}
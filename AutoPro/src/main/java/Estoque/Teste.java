package Estoque;



public class Teste {
 public static void main(String[] args) {
	  Produto produto = new Produto(4.75,"biscoito Negresco");
	  
	 DAO<Produto> dao = new DAO<>(Produto.class);
	 
	dao.ConsultaP("ObterCorridas", "Id", "Azeite de 450 ml");
   }
}

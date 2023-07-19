package Relacio;

public class testeAssento {
  public static void main(String[] args) {
	
	Assento assento = new Assento("4L");  
	Cliente cli = new Cliente("Djalma",assento);
	
    ClienteDAO c = new ClienteDAO(cli,assento);
    
    DAO<Object> dao = new DAO<>();
    DAO<Object> r= dao.Atualizar(5L,"11T");
      System.out.println(r);
    
	 
  

	
	
  }
}

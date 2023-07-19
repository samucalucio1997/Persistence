package logis;

//import java.util.List;

public class TesteLog {
  public static void main(String[] args) {
	DAO<ClienteR> cliente = new DAO<>();
	ClienteR C = new ClienteR("Renan","ttw193tp");
	ClienteE k = new ClienteE(C.getNome(),C.getProtocolo(),7230.0);
	System.out.println(cliente.BuscaID(1L));
	
 } 
}

package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
  public static void main(String[] args) throws SQLException {
	  Scanner d = new Scanner(System.in);
	  System.out.println("Informe o código da pessoa:");
	  int id = d.nextInt();
	  
	  
	  String select = "Select código,nome  from pessoas where código = ?";
      Connection con = Conexao.getConexao();
      PreparedStatement stmt = con.prepareStatement(select);
      stmt.setInt(1, id);
      
      
      ResultSet r = stmt.executeQuery();
    
      if(r.next()) {
    	  Pessoa p =new Pessoa(r.getInt(1), r.getString(2));
    	  System.out.println("O nome atual: " + p.getNome() + "\n e código: "+ p.getCodigo());
    	  System.out.println("Informe o nome da pessoa que vc deseja deletarlhes:");
    	  String nnome = d.next();
    	  String delete = "delete from pessoas where nome=?";
    	  stmt.setString(1, nnome);
    	
    	  stmt.execute(delete);
    	  
      }
}
}

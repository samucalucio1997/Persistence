package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertion {
     public static void main(String[] args) throws SQLException {
    	 Scanner d = new Scanner(System.in);
    	 System.out.println("Informe o nome:");
          String nome = d.nextLine();
          
          Connection conexao = Conexao.getConexao();
          String sql = "INSERT INTO pessoas (nome) VALUES (?)";
          PreparedStatement stm = conexao.prepareStatement(sql);
          stm.setString(1, nome);
          stm.execute();
          System.out.println("Foi inserido com sucesso!!");
          
	   
	   d.close();
  }
}

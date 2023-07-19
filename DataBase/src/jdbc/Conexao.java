package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  public static Connection getConexao() throws SQLException {
	  Connection con = null;
	  final String url = "jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSl=true";
	  final String senha ="gripenng";
	  final String usuario = "root";
	  
	  con = DriverManager.getConnection(url, usuario, senha);
	  System.out.println("Conexao feita");
	  return con;
	  
}
}

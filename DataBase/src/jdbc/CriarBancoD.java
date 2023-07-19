package jdbc;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoD {
   public static void main(String[] args) throws SQLException {
//	    Connection conexao =null;
//		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
//		final String usuario = "root";
//		final String senha = "gripenng";
//		
//	        conexao = DriverManager.getConnection(url, usuario, senha);
	  
	      Connection a = Conexao.getConexao();
		  Statement stm = a.createStatement();
		  stm.execute("create database if not exists curso_java");
		  
		  
		  System.out.println("BD criado com sucesso");
		  
	      
   }
}

package projeto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
      public static Connection preConectar() throws SQLException, IOException{
    	 
    	 Properties pro = getConexao();
         final String url = pro.getProperty("banco.url");
         final String usser =pro.getProperty("banco.usuario");
         final String pass=pro.getProperty("banco.senha");
           
          return DriverManager.getConnection(url, usser, pass);      
      }
      public static Properties getConexao() throws IOException {
    	  Properties pro =new Properties();
    	  String path = "/Conexao.properties";
    	  pro.load(Conexao.class.getResourceAsStream(path));
    	  return pro;
      }
     
}

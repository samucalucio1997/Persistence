package jdbc2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConeMim {
  public static Connection getConnect() throws SQLException, IOException {
	Connection back = null;
	Properties d = CaminhoCon();
	String url =d.getProperty("Banco url");
    String usuario = d.getProperty("Banco usuario");
    String senha = d.getProperty("Banco senha");
    back = DriverManager.getConnection(url, usuario, senha);
    System.out.println("Conexao feita");
    return back;
 }
  public static Properties CaminhoCon() throws IOException {
	  Properties hum = new Properties();
	  String caminho="/Conexaomimos";
	  hum.load(ConeMim.class.getResourceAsStream(caminho));
	  return hum;
  }
}

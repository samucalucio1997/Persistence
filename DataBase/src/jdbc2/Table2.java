package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table2 {
    public static void main(String[] args) throws SQLException {
	String url = "jdbc:mysql://localhost/mimos";
	String senha = "gripenng";
	String usuario = "root";
	
	Connection con = DriverManager.getConnection(url, usuario, senha);
	String sql1 = "create table if not exists censo ("
			+ "id int auto_increment primary key,"
			+ "nacionalidade varchar(20) not null default 'brasileiro',"
			+ "nome varchar(80) not null,"
			+ "salario float"
			+ ")";
	    Statement stm = con.createStatement();
	    stm.execute(sql1);
	    System.out.println("'censo'criada com sucesso");
	
  }
}

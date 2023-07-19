package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
     public static void main(String[] args) throws SQLException {
		Connection conexao =Conexao.getConexao();
		String sql = "create table if not exists pessoas ("
				+ "código INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL"
				+ ""
				+ ")";
		
		
		Statement stm = conexao.createStatement();
		stm.execute(sql);
		System.out.println("blz");
		
		
	}
}

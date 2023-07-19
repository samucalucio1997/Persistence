package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoa {
     public static void main(String[] args) throws SQLException {
    	
		Connection con = Conexao.getConexao();
		String sql = "select * from pessoas ";
		System.out.println("digite as iniciais");
		
		Statement das = con.createStatement();
		
		ResultSet resultado = das.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			int codigo = resultado.getInt("código");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo,nome));
		}
		
		for(Pessoa k: pessoas) {
	       System.out.println(k.getCodigo() + "==>" + k.getNome());		
		}
		
		
		con.close();
	}
}

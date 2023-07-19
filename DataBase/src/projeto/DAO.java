package projeto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DAO {
   private Connection Conexao;
   
   public int incluir(String sql, Object... atributo) {
	   try {
		PreparedStatement stmt = projeto.Conexao.preConectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	    AdicionarAtributo(stmt, atributo);
	       if(stmt.executeUpdate()>0) {
	    	   ResultSet resultado = stmt.getGeneratedKeys();
	    	   if(resultado.next()) {
	    		   return resultado.getInt(1);
	    	   }
	       }
	          return -1;
	   } catch (SQLException e) {
		   throw new RuntimeException();
	 } catch (IOException e) {
		 throw new RuntimeException();
	 }
   }
   
   public void close() throws SQLException {
	   if(jdbc.Conexao.getConexao().isClosed()==false) {
		   Conexao.close();
	   }
   }
   
   public void AdicionarAtributo(PreparedStatement stmt, Object[] lao) throws SQLException {
	 int indice = 1;
	 for(Object atributo:lao) {
		 if(atributo instanceof String) {
			 stmt.setString(indice, (String) atributo);
		 }else if(atributo instanceof Integer) {
			 stmt.setInt(indice,(Integer) atributo);
		 }
		 indice++;
	 }
   }
   public void Consulta(String like) throws IOException {
	   try {
		   Connection con =null;
		   con=projeto.Conexao.preConectar();
		   String sql = "select*from pretest where nome like ?";	   
         PreparedStatement stmt = con.prepareStatement(sql);		
		stmt.setString(1, "%"+like+"%");
		ResultSet re = stmt.executeQuery();
		List<Cliente> cli = new ArrayList<>();
		while(re.next()) {
			cli.add(new Cliente(re.getString("cpf"),re.getString("nome")));
		}
		for(Cliente k:cli) {
			System.out.println(k.getCpf()+" "+k.getNome());
		}
		
	} catch (SQLException e) {
		throw new  RuntimeException();
	}
   }
   
   public void Atualizar(String nome,String novo) {
	   String sql ="update pretest set nome=? where nome=?";
	
		try {
			Connection con = projeto.Conexao.preConectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, novo);
			stmt.setString(2, nome);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
   }
}

package projeto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cadastro {	
    
   public Connection InsertInto(Cliente cliente) throws SQLException, IOException{
	   Connection con =null;
	   
		con = Conexao.preConectar();
		String in = "insert into pretest (cpf,nome) values (?,?)";
		PreparedStatement stm = con.prepareStatement(in);
		stm.setString(1,cliente.getCpf() );
		stm.setString(2,cliente.getNome() );
		stm.execute();
		System.out.println("inserido com sucesso");
		
		return con;

   }
   
   public Connection Consulta(Cliente cliente) throws SQLException, IOException {
	   Connection con = Conexao.preConectar();
	  
	   try {
		   String cosul = "Select * from pretest where cpf = ?";
		PreparedStatement stmt = con.prepareStatement(cosul);
		stmt.setString(1,cliente.getCpf() );
		ResultSet resultado = stmt.executeQuery(cosul);
		List <Cliente> cli = new ArrayList<>();
		while(resultado.next()) {
		    String cpf = resultado.getString("cpf");
		    String nome= resultado.getString("nome");
		    cli.add(new Cliente(cpf,nome));
		}
		
		for(Cliente p: cli) {
			System.out.println(p.getCpf() + " ==> "+p.getNome());
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	}
	   return con;
   }
   
   public Connection atualizar(Cliente cliente) throws SQLException, IOException{
	   Connection con = Conexao.preConectar();
	   Scanner mo = new Scanner(System.in);
	   String update = "update pretest set nome =? where cpf =?";
	   PreparedStatement stm = con.prepareStatement(update);
	   stm.setString(2, cliente.getCpf());
	   stm.setString(1,cliente.getNome());
	   stm.execute();
	   mo.close();
	   return con;
   }
   
   public Connection  deletar() throws SQLException, IOException{
	   Connection con = Conexao.preConectar();
	   Scanner fer = new Scanner(System.in);
	   System.out.println("Qual o codigo cpf?");
	   String id = fer.next();
	   String sultar = "select * from pretest where cpf = ?";
	   PreparedStatement stm = con.prepareStatement(sultar);
	   stm.setString(1, id);
	   ResultSet r = stm.executeQuery();
	   System.out.println(r.getNString(id));
	   System.out.println("Deseja, realmente, excluir este cliente?");
	   String certe=fer.next();
	   if(r.next() && r!=null) {
		   if(certe=="sim"||certe=="Sim"||certe=="s"||certe=="S") {
			   String delete= "delete from pretest where cpf = ?";
			   stm.setString(1, id);
			   stm.execute(delete);			   
		   }
	   }
	   fer.close();
	   return con;
   }
  
   
   
}

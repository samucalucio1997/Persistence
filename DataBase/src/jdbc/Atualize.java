package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Atualize {
       public static void main(String[] args) throws SQLException {
    	   Scanner j = new Scanner(System.in);
		 Connection con = Conexao.getConexao();
		 System.out.println("Informe o novo valor:");
		 String com = j.nextLine();
		 System.out.println("Informe qual dado vc deseja trocar:");
		 int dafur = j.nextInt();
		 String sql ="update pessoas set nome = ? where código = ?";
		 PreparedStatement stm = con.prepareStatement(sql);
		 stm.setString(1,com);
		 stm.setInt(2, dafur);
		 stm.execute();
		 System.out.println("atualizado com sucesso!!");
		  
		 j.close();
		 
	}
}

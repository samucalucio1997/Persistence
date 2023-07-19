package jdbc2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InseMimos {
   public static void main(String[] args) throws SQLException {
	 Connection con = null;
	try {
		con = ConeMim.getConnect();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Scanner tac = new Scanner(System.in);
	 System.out.println("Informe a nacionalidade:");
	 String p = tac.next();
	 System.out.println("Informe o nome:");
	 String name = tac.next();
	 System.out.println("Informe o salario");
	 float sal = tac.nextFloat();
	 
	 String insere = "insert into censo (nacionalidade, nome, salario) VALUES (?,?,?)";
	 PreparedStatement stmt = con.prepareStatement(insere);
	 
	 stmt.setString(1,p);
	 stmt.setString(2, name);
	 stmt.setFloat(3, sal);
     stmt.execute();
     System.out.println("Foi inserido com sucedido!");
     tac.close();
  }
}

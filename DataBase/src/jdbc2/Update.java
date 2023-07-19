package jdbc2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
   public static void main(String[] args) throws SQLException  {
	   Scanner pro=new Scanner(System.in);
	Connection con=null;
	try {
		con = ConeMim.getConnect();
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Informe o nome do funcionario:");
	String nome = pro.next();
	System.out.println("Informe o novo salario do funcionário:");
	float kt = pro.nextFloat();
	String update = "update censo set salario = ? where nome = ?";
	PreparedStatement stm= con.prepareStatement(update);
	stm.setFloat(1, kt);
	stm.setString(2,nome);
	stm.execute();
	System.out.println("Atualização feita com sucesso!!");
	pro.close();
 }
}

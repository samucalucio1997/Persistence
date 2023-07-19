package jdbc2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete2 {
    public static void main(String[] args) throws SQLException {
    	Scanner k = new Scanner(System.in);
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
		System.out.println("Informe qual funcionario deseja deletar");
		String fun = k.next();
		String delete="delete from censo where nome=?";
		PreparedStatement stm = con.prepareStatement(delete);
		stm.setString(1, fun);
		stm.execute();
		k.close();
		System.out.println("Valor deletado com sucesso!!");
	}
}

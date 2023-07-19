package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaCriterio {
       public static void main(String[] args) throws SQLException {
		Connection con = Conexao.getConexao();
		Scanner ent = new Scanner(System.in);
	    System.out.println("Pesquisar:");
		String pes = ent.next();
		String sql = "select * from pessoas where nome like ?";
		PreparedStatement fal = con.prepareStatement(sql);
		fal.setString(1, "%"+pes+"%");
		ResultSet resultado = fal.executeQuery();
		List<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			int codigo = resultado.getInt("código");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo,nome));
		}
		
		for(Pessoa l: pessoas) {
			System.out.println(l.getCodigo() + "==>" + l.getNome());
		}
		ent.close();
		
	}
}

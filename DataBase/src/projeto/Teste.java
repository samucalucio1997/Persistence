package projeto;

import java.io.IOException;
import java.sql.SQLException;

public class Teste {
      public static void main(String[] args){
	  DAO dao = new DAO();
	  
	  try {
		dao.Consulta("Djalma");
	   
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  	  
   }
}

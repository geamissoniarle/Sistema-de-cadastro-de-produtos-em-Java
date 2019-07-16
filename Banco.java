package teste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.DatabaseMetaData; 

public class Banco {


	// cria a conexão com o banco de dados
	
 public static void Connect() throws SQLException{
	 Connection conn = null;
	 
  try{
	  String url = "jdbc:sqlite:C:/Users/S13Ro/Banc.db";
	  
	  conn = DriverManager.getConnection(url);
	  System.out.println("Connection by SQLite Sucessful");
  } catch(Exception e){
	  System.out.println(e.getMessage());
	  
  } finally{
	  try {
	  if (conn != null){
		  conn.close();
		  }
	  } catch (Exception ex){
		System.out.println(ex.getMessage());
		
	  }
  }
 }
  public static void main(String[] args) throws SQLException {
	Connect();
}
	
}




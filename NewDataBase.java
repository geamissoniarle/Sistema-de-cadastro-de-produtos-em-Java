package teste;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.DatabaseMetaData; 

public class NewDataBase {
	
			public static void createNewDatabase(String fileName) {

String url = "jdbc:sqlite:C:\\Users\\S13Ro\\bancoDeDados.db" + fileName;

	try (Connection conn = DriverManager.getConnection(url)) {
		if (conn != null) {
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println("The driver name is " + meta.getDriverName());
	System.out.println("A new database has been created.");
		            }
		 
		        } catch (SQLException e) {
	System.out.println(e.getMessage());
		        }
		    }
		public static void main(String[] args) {
		createNewDatabase("bancoDeDados.db");
		    }
		}


import java.sql.*;
import javax.swing.*;
public class Javaconnect {
	 Connection conn = null;
	public static Connection getDBConnection() throws SQLException{
		try
		{
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:Hotel.db");
			return conn;
			
		}catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
			return null;
		}



}
}

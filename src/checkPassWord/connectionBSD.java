package checkPassWord;
import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class connectionBSD {
	public static Connection getConnection() {
		Connection conn=null;
		
	
	try {
		  
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login","root","Akram_2002@44");
		
		
		
	} catch (Exception e) {
		
		JOptionPane.showMessageDialog(null,"Echec de connexion");
	}
	return conn;
	 


	}
	
}

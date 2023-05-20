package cms;

import java.sql.*;

public class MyConnection {
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/cms","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;	
	}
	

}

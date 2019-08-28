package dbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class dbConnection {
	
	public dbConnection(){
		
	}

	public Connection getConnection(){
		
		//Create a connection string
		String connectionUrl = "jdbc:mySQL://jujudatabase.cyqk3tabjhdq.us-east-2.rds.amazonaws.com:3306/buyMe";
		Connection conn = null;
		
		try {
			//Load JDBC driver - the interface standardizing the connection procedure. Look at WEB-INF\lib for a mysql connector jar file, otherwise it fails.
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Create a connection to your DB
			conn = DriverManager.getConnection(connectionUrl,"jujuzzz", "lightness!0831");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public void closeConnection(Statement sta,Connection conn){
		try {
			sta.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection(ResultSet rs, Statement sta, Connection conn) {
		try {
			rs.close();
			sta.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


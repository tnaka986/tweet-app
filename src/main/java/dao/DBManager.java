package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.rdbms.AppEngineDriver;

public class DBManager {

	public static Connection getCloudSQLConnection() {
		
		// Cloud SQL
		String url = "jdbc:google:rdbms://lateral-apex-268306:us-central1:tweet-app/tweetapp";
		// ローカル用
//		String url = "jdbc:mysql://localhost:3306/tweetapp";
		
		final String DB_USER = "mysql";
		final String DB_PASS = "mysql";
		
		try {
			DriverManager.deregisterDriver(new AppEngineDriver());
			Connection con = DriverManager.getConnection(url, DB_USER, DB_PASS);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
}

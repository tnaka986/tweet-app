package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.rdbms.AppEngineDriver;

public class DBManager {

	public static Connection getCloudSQLConnection() {
		
		// Cloud SQL
		String url = "jdbc:google:rdbms://<project-name>:<rejion>:tweet-app/tweetapp";
		// ローカル用
//		String url = "jdbc:mysql://localhost:3306/tweetapp";
		
		final String DB_USER = "*****";
		final String DB_PASS = "*****";
		
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

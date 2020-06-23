package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {

	public User findUser(User user) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBManager.getCloudSQLConnection();
			stmt = con.prepareStatement("SELECT * FROM USER WHERE user_name = ?");
			stmt.setString(1, user.getUserName());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int userNo = rs.getInt("USER_NO");
				String userName = rs.getString("USER_NAME");
				String pass = rs.getString("password");
				return new User(userNo, userName, pass);
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean registUser(User user) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBManager.getCloudSQLConnection();
			stmt = con.prepareStatement("INSERT INTO USER(USER_NAME,PASSWORD) "
					+ "VALUES(?,?)");
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPass());
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
		
	}	
	
}

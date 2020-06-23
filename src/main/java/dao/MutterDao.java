package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Mutter;
import entity.User;

public class MutterDao {
	
	public List<Mutter> findAll() {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		con = DBManager.getCloudSQLConnection();
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM MUTTER "
					+ "INNER JOIN USER ON MUTTER.USER_NO = USER.USER_NO "
					+ "ORDER BY POST_DATE DESC");
			
			ResultSet rs = stmt.executeQuery();
			List<Mutter> mutterList = new ArrayList<Mutter>();
			
			while(rs.next()) {
				
				String content = rs.getString("CONTENT");
				int userNo = rs.getInt("USER_NO");
				String userName = rs.getString("USER_NAME");
				Timestamp postDate = rs.getTimestamp("POST_DATE");
				
				Mutter mutter = new Mutter(content, new User(userNo, userName), postDate);
				mutterList.add(mutter);
				
			}
			
			return mutterList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertMutterContent(Mutter mutter) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		con = DBManager.getCloudSQLConnection();
		
		try {
			
			stmt = con.prepareStatement("INSERT INTO MUTTER (CONTENT,USER_NO,POST_DATE) "
					+ "VALUES(?,?,?)");
			
			stmt.setString(1, mutter.getContent());
			stmt.setInt(2, mutter.getUser().getUserNo());
			stmt.setTimestamp(3, mutter.getPostDate());
			
			stmt.executeUpdate();
			
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

package tw.com.demo.web.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	private final String DBU_DRIVER="com.mysql.cj.jdbc.Driver";
	private final String DBU_URL="jdbc:mysql://127.0.0.1:3306/demo01?serverTimezone=UTC&useSSL=false";
	private final String DBU_USER="root";
	private final String DBU_PASS="tim10270415";
	private Connection conn;
	
	private DBUtil() {
		try {
			Class.forName(DBU_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static DBUtil getDB() {
		return new DBUtil();
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(DBU_URL, DBU_USER, DBU_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	public void close(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(Statement st) throws SQLException {
		if(st != null) {
			st.close();
		}
		
	}
	
	public void close(ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
		}
	}
	
	
}


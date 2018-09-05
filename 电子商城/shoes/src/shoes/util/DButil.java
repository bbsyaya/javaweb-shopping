package shoes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class DButil {
	private static Connection connection;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoes?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8";
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("注册失败");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭失败");
			e.printStackTrace();
		}
	}
	
	public static Statement getStatement() {
		Statement stm = null;
		try {
			stm = connection.createStatement();
			return stm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stm;
	}
	
	public static void closeStatement(Statement stm) {
		try {
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭失败");
			e.printStackTrace();
		}
	}
	
	public static PreparedStatement getPreparStatement(String sql) {
		PreparedStatement pstm=null;
		try {
			pstm = connection.prepareStatement(sql);
			return pstm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstm;
	}
	
	public static void closePreparStatement(PreparedStatement pstm) {
		try {
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭失败");
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResultset(Statement stm,String sql) {
		ResultSet rs=null;
		try {
			rs = stm.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getResultset(PreparedStatement pstm) {
		ResultSet rs=null;
		try {
			rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeResultset(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭失败");
			e.printStackTrace();
		}
	}
}

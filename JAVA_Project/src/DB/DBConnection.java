package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBConnection {


    private static Connection conn = null; // DB연결된 상태(세션)을 담은 객체


	public static Connection getConnection() {
		try {
            String user = "temp"; 
            String pw = "1234";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("DB 연결 성공 !!");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러!!");
			} catch (SQLException e) {    	
			System.out.println("DB 연결 에러!!");
		}

        return conn;
	}
	public static void DBExit() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInstruction {

    private static Connection conn = null; // DB연결된 상태(세션)을 담은 객체
    private static PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
    private static ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체


	public static ResultSet getResultSet(String query) {
		try {            
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			System.out.println(query);
			return pstm.executeQuery();
		} catch (SQLException e) {
			System.out.println("쿼리오류 : " + query);
			e.printStackTrace();
			return null;
		}
	}

	public static int executeQuery(String query) {
		try {
			return pstm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리오류 : " + query);
		}
		return 0;
	}

	public static boolean execute(String query) {
		try {
			return pstm.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리오류 : " + query);
		}
		return false;
	}
	

}

package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PrepareStatement 변수 바인딩 하기
public class DBEx03 {

	public static void login(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB 연결완료");

			String sql = "SELECT * FROM userTbl WHERE username = ? AND password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 물음표 시작번지 1
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery(); // SELECT

			while (rs.next()) {
				System.out.println(username + "로그인 되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		login("ssar", "1234");
	}
}
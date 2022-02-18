package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {

		try { // 통신은 예외가 발생할 수 있기 때문에 trycatch로 묶는다.
				// 1. connection 연결(세션생성) port, ip, id, password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("db연결완료");

			// 2. buffer달아서 통신 (ALL:SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // emp 끝에 세미콜론 필요 없음
			PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼에 넣어두고
			ResultSet rs = pstmt.executeQuery(); // select할 때 = flush 하는것!!
			// pstmt.executeUpdate(); //insert, update, delete할 때 -> 자동 커밋도 돼야함
			// rs.next(); // 커서를 한칸 내리는것
			// System.out.println(rs.next());

			while (rs.next()) { // 한칸 커서 내리면서 리턴값이 트루일 때만 와일을 돌린다.
				System.out.println("empno: " + rs.getInt("empno"));
				System.out.println("ename: " + rs.getString("ename"));
				System.out.println("=============================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

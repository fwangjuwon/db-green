package site.metacoding.db;

import java.sql.Connection;
//insert
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBEx06 {

	public static void main(String[] args) {

		try { // 통신은 예외가 발생할 수 있기 때문에 trycatch로 묶는다.
				// 1. connection 연결(세션생성) port, ip, id, password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("db연결완료");

			// 2. buffer달아서 통신 (ALL:SELECT * FROM emp)
			String sql = "INSERT INTO userTbl(id, username, password, gender) VALUES(?,?,?,?)"; // emp 끝에 세미콜론 필요 없음
			PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼에 넣어두고
			pstmt.setInt(1, 5); // 물음표의 순서, 넣을값
			pstmt.setString(2, "dangddo");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "남");

			// 에러: -1, 성공: 수행된 row개수, 변화 없음: 0
			// ex) delete -> 7번 id삭제하려고하면 없는걸 삭제하는거니까 0이 뜬다.
			// 3번 id삭제하라고 하면 3번이 삭제되었으니까, 1행이 수행되어서 1이 뜬다.

			int result = pstmt.executeUpdate(); // delete, update, insert (내부에 commit존재)

			if (result > 0) {
				System.out.println("셩공");
			} else {

				System.out.println("실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

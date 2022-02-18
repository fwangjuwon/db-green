package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {

		try { // ����� ���ܰ� �߻��� �� �ֱ� ������ trycatch�� ���´�.
				// 1. connection ����(���ǻ���) port, ip, id, password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("db����Ϸ�");

			// 2. buffer�޾Ƽ� ��� (ALL:SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // emp ���� �����ݷ� �ʿ� ����
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���ۿ� �־�ΰ�
			ResultSet rs = pstmt.executeQuery(); // select�� �� = flush �ϴ°�!!
			// pstmt.executeUpdate(); //insert, update, delete�� �� -> �ڵ� Ŀ�Ե� �ž���
			// rs.next(); // Ŀ���� ��ĭ �����°�
			// System.out.println(rs.next());

			while (rs.next()) { // ��ĭ Ŀ�� �����鼭 ���ϰ��� Ʈ���� ���� ������ ������.
				System.out.println("empno: " + rs.getInt("empno"));
				System.out.println("ename: " + rs.getString("ename"));
				System.out.println("=============================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

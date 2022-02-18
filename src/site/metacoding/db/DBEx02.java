package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//dept ���̺��� ��� ������ ����ϼ���.
// select deptno, dname, loc from dept;

public class DBEx02 {

	public static void main(String[] args) {
		try { // ����� ���ܰ� �߻��� �� �ֱ� ������ trycatch�� ���´�.
				// 1. connection ����(���ǻ���) port, ip, id, password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("db����Ϸ�");

			// 2. buffer�޾Ƽ� ��� (ALL:SELECT * FROM emp)
			String sql = "SELECT deptno, dname, loc FROM dept"; // emp ���� �����ݷ� �ʿ� ����
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���ۿ� �־�ΰ�
			ResultSet rs = pstmt.executeQuery(); // select�� �� = flush �ϴ°�!!
			// pstmt.executeUpdate(); //insert, update, delete�� �� -> �ڵ� Ŀ�Ե� �ž���
			// rs.next(); // Ŀ���� ��ĭ �����°�
			// System.out.println(rs.next());

			while (rs.next()) { // ��ĭ Ŀ�� �����鼭 ���ϰ��� Ʈ���� ���� ������ ������.
				System.out.println("deptno: " + rs.getInt("deptno"));
				System.out.println("dname: " + rs.getString("dname"));
				System.out.println("loc: " + rs.getString("loc"));
				System.out.println("=============================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

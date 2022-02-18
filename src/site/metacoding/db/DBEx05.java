package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//dept ���̺��� ��� ������ ����ϼ���.
// select deptno, dname, loc from dept;

public class DBEx05 {

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

			List<Dept> depts = new ArrayList<>();

			while (rs.next()) { // ��ĭ Ŀ�� �����鼭 ���ϰ��� Ʈ���� ���� ������ ������.

				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				depts.add(dept);
			}

			// for each�� �̿��ؼ� ���
			for (Dept dept : depts) { // ����: �÷��� Ÿ��, ������: �÷���,
				System.out.println("deptno: " + dept.getDeptno());
				System.out.println("dname: " + dept.getDname());
				System.out.println("loc: " + dept.getLoc());
				System.out.println("=============================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
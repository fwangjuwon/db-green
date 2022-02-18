package site.metacoding.db;

import java.sql.Connection;
//insert
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//id 1�� username�� coding���� ���� 
public class DBEx08 {

	public static void main(String[] args) {

		try { // ����� ���ܰ� �߻��� �� �ֱ� ������ trycatch�� ���´�.
				// 1. connection ����(���ǻ���) port, ip, id, password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("db����Ϸ�");

			// 2. buffer�޾Ƽ� ��� (ALL:SELECT * FROM emp)
			String sql = "UPDATE userTbl SET username = ? WHERE id = ?"; // emp ���� �����ݷ� �ʿ� ����
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���ۿ� �־�ΰ�

			pstmt.setString(1, "coding");
			pstmt.setInt(2, 1);
			// ����: -1, ����: ����� row����, ��ȭ ����: 0
			// ex) delete -> 7�� id�����Ϸ����ϸ� ���°� �����ϴ°Ŵϱ� 0�� ���.
			// 3�� id�����϶�� �ϸ� 3���� �����Ǿ����ϱ�, 1���� ����Ǿ 1�� ���.

			int result = pstmt.executeUpdate(); // delete, update, insert (���ο� commit����)

			if (result > 0) {
				System.out.println("�Ͱ�");
			} else {

				System.out.println("����");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
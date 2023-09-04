package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.BookVo;
import hr.dao.vo.EmployeesVo;

public class BookDao {

	public void updateRent(BookVo vo) {
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.176:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. Statement 객체 생성
			String sql = 
					" select a.no, a.title, a.rent, b.name" +
					"   from book a, author b" +
					"  where a.author_no = b.no" +
					"    and a.no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// 4. binding
			pstmt.setInt(1, vo.getNo());

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			
			// 6. 결과 처리
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				
				EmployeesVo vo = new EmployeesVo();
				vo.setEmpNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 7. 자원정리
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<BookVo> findAll() {
		
		return null;
	}

}

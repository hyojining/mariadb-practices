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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.176:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. Statement 객체 생성
			String sql = 
					" update book" +
					"    set rent = ?" + 
					"  where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// 4. binding
			pstmt.setString(1, vo.getRent());
			pstmt.setInt(2, vo.getNo());

			// 5. SQL 실행
			pstmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
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
					" select a.title, b.name, a.rent" +
					"   from book a, author b" +
					"  where a.author_no = b.no";
			
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			
			// 6. 결과 처리
			while(rs.next()) {
				String title = rs.getString(1);
				String name = rs.getString(2);
				String rent = rs.getString(3);
				
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setName(name);
				vo.setRent(rent);
				
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
		return result;
	}

}

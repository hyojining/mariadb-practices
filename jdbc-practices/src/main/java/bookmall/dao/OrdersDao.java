package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrdersVo;

public class OrdersDao {
	public void insertOrders(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMember_no());
			pstmt.setLong(2, vo.getOrder_code());
			pstmt.setString(3, vo.getAddress());
			pstmt.setLong(4, vo.getTotal_price());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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

	public List<OrdersVo> findAllOrders() {
		List<OrdersVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = " select a.no, a.member_no, a.order_code, a.address, a.total_price, b.name, b.email" +
						 "   from orders a, member b" +
						 "  where a.member_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				Long member_no = rs.getLong(2);
				Long order_code = rs.getLong(3);
				String address = rs.getString(4);
				Long total_price = rs.getLong(5);
				String member_name = rs.getString(6);
				String member_email = rs.getString(7);
				
				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setMember_no(member_no);
				vo.setOrder_code(order_code);
				vo.setAddress(address);
				vo.setTotal_price(total_price);
				vo.setMember_name(member_name);
				vo.setMember_email(member_email);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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
	
	public void insertOrderBook(OrderBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into order_book values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBook_no());
			pstmt.setLong(2, vo.getOrder_no());
			pstmt.setLong(3, vo.getCount());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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
		updateOrdersTotalPrice(vo);
	}

	private void updateOrdersTotalPrice(OrderBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql1 = " select c.price, b.count"	+ 
						  "   from orders a, order_book b, book c" + 
						  "  where a.no = ?" + 
						  "    and b.book_no = c.no";
			pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setLong(1, vo.getOrder_no());
			
			rs = pstmt1.executeQuery();
			
			Long total_price = 0L;
			while(rs.next()) {
				Long price = rs.getLong(1);
				int count = rs.getInt(2);
				
				total_price += price * count;
			}
			
			String sql2 = 
					" update orders" +
					"    set total_price=?" +
					"  where no=?";
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt2.setLong(1, total_price);
			pstmt2.setLong(2, vo.getOrder_no());
			
			pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt2 != null) {
					pstmt2.close();
				}
				if(pstmt1 != null) {
					pstmt1.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<OrderBookVo> findAllOrderBook() {
		List<OrderBookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = " select a.book_no, a.order_no, a.count, b.title" +
						 "   from order_book a, book b" +
						 "  where a.book_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long book_no = rs.getLong(1);
				Long order_no = rs.getLong(2);
				Long count = rs.getLong(3);
				String book_title = rs.getString(4);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setBook_no(book_no);
				vo.setOrder_no(order_no);
				vo.setCount(count);
				vo.setBook_title(book_title);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.0.176:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
}

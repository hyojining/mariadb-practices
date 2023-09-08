package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {

		insertOrders();
		findAllOrders();
		
		insertOrderBook();
		findAllOrderBook();
		
	}
	
	public static void insertOrders() {
		OrdersVo vo = new OrdersVo();
		vo.setMember_no(1L);
		vo.setOrder_code(230907L);
		vo.setAddress("서울특별시 강남구");
		vo.setTotal_price(0L);
		new OrdersDao().insertOrders(vo);
	}
	
	public static void findAllOrders() {
		List<OrdersVo> list = new OrdersDao().findAllOrders();
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void insertOrderBook() {
		OrderBookVo vo1 = new OrderBookVo();
		vo1.setBook_no(1L);
		vo1.setOrder_no(1L);
		vo1.setCount(1L);
		new OrdersDao().insertOrderBook(vo1);
		
		OrderBookVo vo2 = new OrderBookVo();
		vo2.setBook_no(3L);
		vo2.setOrder_no(1L);
		vo2.setCount(1L);
		new OrdersDao().insertOrderBook(vo2);
	}

	public static void findAllOrderBook() {
		List<OrderBookVo> list = new OrdersDao().findAllOrderBook();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}

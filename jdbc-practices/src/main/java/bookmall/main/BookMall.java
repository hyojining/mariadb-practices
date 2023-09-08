package bookmall.main;

import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.MemberDaoTest;
import bookmall.dao.test.OrdersDaoTest;

public class BookMall {

	public static void main(String[] args) {
		
		// insert
		MemberDaoTest.insertMember();
		CategoryDaoTest.insertCategory();
		BookDaoTest.insertBook();
		CartDaoTest.insertCart();
		OrdersDaoTest.insertOrders();
		OrdersDaoTest.insertOrderBook();
		
		System.out.println("## 회원리스트");
		MemberDaoTest.findAllMember();
		System.out.println();
		
		System.out.println("## 카테고리");
		CategoryDaoTest.findAllCategory();
		System.out.println();
		
		System.out.println("## 상품");
		BookDaoTest.findAllBook();
		System.out.println();
		
		System.out.println("## 카트");
		CartDaoTest.findAllCart();
		System.out.println();
		
		System.out.println("## 주문");
		OrdersDaoTest.findAllOrders();
		System.out.println();
		
		System.out.println("## 주문도서");
		OrdersDaoTest.findAllOrderBook();
		System.out.println();

	}

}

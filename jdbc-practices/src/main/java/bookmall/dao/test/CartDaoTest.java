package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertCart();
		findAllCart();
	}

	public static void insertCart() {
		CartVo vo1 = new CartVo();
		vo1.setMember_no(1L);
		vo1.setBook_no(1L);
		vo1.setCount(1L);
		new CartDao().insertCart(vo1);
		
		CartVo vo2 = new CartVo();
		vo2.setMember_no(1L);
		vo2.setBook_no(3L);
		vo2.setCount(1L);
		new CartDao().insertCart(vo2);
	}

	public static void findAllCart() {
		List<CartVo> list = new CartDao().findAllCart();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}

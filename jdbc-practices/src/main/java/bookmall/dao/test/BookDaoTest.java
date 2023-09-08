package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertBook();
		findAllBook();
	}

	public static void insertBook() {
		BookVo vo1 = new BookVo();
		vo1.setCategory_no(1L);
		vo1.setTitle("모순");
		vo1.setPrice(13000L);
		new BookDao().insertBook(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setCategory_no(2L);
		vo2.setTitle("내면소통");
		vo2.setPrice(14000L);
		new BookDao().insertBook(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setCategory_no(3L);
		vo3.setTitle("오펜하이머");
		vo3.setPrice(15000L);
		new BookDao().insertBook(vo3);
	}
	
	public static void findAllBook() {
		List<BookVo> list = new BookDao().findAllBook();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}

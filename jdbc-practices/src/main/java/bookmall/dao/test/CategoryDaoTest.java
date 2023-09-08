package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertCategory();
		findAllCategory();
	}

	public static void insertCategory() {
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		new CategoryDao().insertCategory(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("인문");
		new CategoryDao().insertCategory(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setName("예술");
		new CategoryDao().insertCategory(vo3);
	}
	
	public static void findAllCategory() {
		List<CategoryVo> list = new CategoryDao().findAllCategory();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}

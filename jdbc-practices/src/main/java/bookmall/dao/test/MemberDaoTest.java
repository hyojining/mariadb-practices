package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		insertMember();
		findAllMember();
	}

	public static void insertMember() {
		MemberVo vo1 = new MemberVo();
		vo1.setName("김효진");
		vo1.setPhone("010-1234-5678");
		vo1.setEmail("gywls@gmail.com");
		vo1.setPw("gywls1234");
		new MemberDao().insertMember(vo1);
		
		MemberVo vo2 = new MemberVo();
		vo2.setName("쿠로미");
		vo2.setPhone("010-8765-4321");
		vo2.setEmail("kuromi@gmail.com");
		vo2.setPw("kuromi8765");
		new MemberDao().insertMember(vo2);
	}
	
	public static void findAllMember() {
		List<MemberVo> list = new MemberDao().findAllMember();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}



import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.horyun.myapp.domain.MemberVO;
import com.horyun.myapp.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO memberDao;
	
	@Test
	public void testGetTime() {
		System.out.println("현재 DB시간 : " + memberDao.getTime());
	}
	
	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("1111");
		vo.setUsername("홍길동");
		vo.setEmail("user00@email.com");
		
		memberDao.insertMember(vo);
	}
}

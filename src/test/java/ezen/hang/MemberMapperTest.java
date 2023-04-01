package ezen.hang;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezen.hang.heritage.domain.member.dto.Member;
import ezen.hang.heritage.domain.member.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	

	@Test
//	@Disabled
	void findByAllTest() {
		log.info("주입받은 프록시 객체: {}", memberMapper);
		List<Member> list = memberMapper.findByAll();
		log.info("전체목록 : {}", list);
	}
	
	
	@Test
//	@Disabled
	void createTest() {
		Member member = new Member();
		member.setUserid("LEE");
		member.setUserpw("1111");
		member.setUsername("이동훈");
		member.setEmail("Hoon@gmail.com");
		member.setUserph(010101040404);
		
		memberMapper.create(member);
		log.info("회원 등록 완료 : {}", member);
	}
	

	

}

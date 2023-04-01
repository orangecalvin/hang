package ezen.hang.heritage.domain.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.hang.heritage.domain.member.dto.Member;
import ezen.hang.heritage.domain.member.mapper.MemberMapper;


/**
 * 회원 관련 비즈니스 메소드 구현
 */
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	

	@Override
	public Member getMember(String id) {
		return null;
	}


	@Override
	public List<Member> getMembers() {
		return null;
	}

	@Override
	public void register(Member member){
		memberMapper.CreateMember(member);
	}
}








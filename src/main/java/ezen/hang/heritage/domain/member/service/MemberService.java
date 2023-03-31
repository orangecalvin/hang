package ezen.hang.heritage.domain.member.service;

import java.util.List;

import ezen.hang.heritage.domain.member.dto.Member;

/**
 * 회원 관련 비즈니스 메소드 선언
 */
public interface MemberService {
	// 회원 전체 조회
	public List<Member> getMembers();
	// 회원 상세 조회
	public Member getMember(String id);
	
	// 기타 회원 관련 비즈니스 메소드들...
}








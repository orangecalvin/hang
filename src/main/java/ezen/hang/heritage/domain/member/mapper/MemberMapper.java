package ezen.hang.heritage.domain.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ezen.hang.heritage.domain.member.dto.Member;

@Mapper


public interface MemberMapper {
	public List<Member> findByAll();
	
    public void create(Member member);
}

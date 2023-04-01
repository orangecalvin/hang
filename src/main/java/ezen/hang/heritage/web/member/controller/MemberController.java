package ezen.hang.heritage.web.member.controller;

import ezen.hang.heritage.domain.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ezen.hang.heritage.domain.member.dto.Member;




@Controller
@RequestMapping("/main")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/members")
    public ResponseEntity<String> registerMember(@ModelAttribute Member member){
        memberService.register(member);
        log.info(member.toString());
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
    }
}

package ezen.hang.heritage.web.member.controller;

import ezen.hang.heritage.domain.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ezen.hang.heritage.domain.member.dto.Member;




@Controller
@RequestMapping("/main")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/members")
    public ResponseEntity<String> registerMember(@ModelAttribute Member member){
        memberService.register(member);
        System.out.println("실행됨");
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
    }
}

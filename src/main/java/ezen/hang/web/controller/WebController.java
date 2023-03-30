package ezen.hang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
}
/* 디버깅용 */
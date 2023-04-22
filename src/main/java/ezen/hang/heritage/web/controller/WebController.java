package ezen.hang.heritage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/main")
	public String main() {
		return "main2";
	}
}
/* 디버깅용 */
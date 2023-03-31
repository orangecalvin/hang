package ezen.hang.heritage.web.comment.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.hang.heritage.domain.comment.dto.Comment;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@GetMapping
	@ResponseBody
	public List<Comment> getComment(){
		
		return null;
	}
}

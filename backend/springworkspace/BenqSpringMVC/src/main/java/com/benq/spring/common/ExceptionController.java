package com.benq.spring.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리용 컨트롤러(프로젝트 전역)
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String catchException(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("msg", e.getMessage());
		return "common/errorPage";
	}
}

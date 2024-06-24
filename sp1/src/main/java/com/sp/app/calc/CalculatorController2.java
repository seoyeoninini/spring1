package com.sp.app.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 클라이언트 요청시 최초 실행.

/*
  - ModelandView
    : 컨트롤러의 처리결과를 전달한 뷰의 이름과 뷰에 전달할 모델을 가지고 있음
 */
@Controller
@RequestMapping("/calc2/*")
public class CalculatorController2 {
	/* @Autowired를 필드에 붙이고, 
	 의존성을 가진 클래스(CalculatorService라고 쓰여 있지만 구현 클래스 - Impl)에 @Service를 붙인다.  
	*/
	
	@Autowired
	private CalculatorService service;
	
	// @RequestMapping(value = "/calc/write", method = RequestMethod.GET)
	@GetMapping("write")
	public ModelAndView form() {
		return new ModelAndView("calc/write"); // write.jsp로 포워딩
	}
	
	
	// request.getParam이 사라짐. Calculator dto가 대신 처리
	@PostMapping("write")
	public ModelAndView submit(Calculator dto) {
		ModelAndView mav = new ModelAndView("calc/result");
		
		int s = service.result(dto);
		
		mav.addObject("dto", dto);
		mav.addObject("result",s);
		
		return mav;
	}
}

package com.sp.app.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 클라이언트 요청시 최초 실행. 
@Controller
@RequestMapping("/calc3/*")
public class CalculatorController3 {
	
	@Autowired
	private CalculatorService service;
	
	// @GetMapping("write") // 아래와 어노테이션과 같은 코드
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String form() {
		/*
		 - 요청 메소드의 리턴 타입이 String 이면 리턴값을 JSP 이름이다.
		 - String로 리턴하면 내부적으로 ModelandView 객체를 생성하여 처리한다.
		    => public ModelandView form()과 ModelandView 객체 생성 안해도 됨!
		 */
		
		return "calc/write"; // write.jsp로 포워딩
	}
	
	// request.getParam이 사라짐. Calculator dto가 대신 처리
	// HttpServletRequest 객체가 필요하면 요청 받는 메소드의 인자에 기술하면 된다.
	// @PostMapping("write") // 아래 어노테이션과 같은 코드
	/*
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String submit(Calculator dto, HttpServletRequest req) {
		
		int s = service.result(dto);
		
		req.setAttribute("dto", dto);
		req.setAttribute("result",s);
		
		return "calc/result";
	}
	*/
	
	// 위와 같은 코드나 아래  
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String submit(Calculator dto, Model model) {
		
		int s = service.result(dto);
		
		// Model : 포워딩할 JSP에 넘길 데이터
		model.addAttribute("dto", dto);
		model.addAttribute("result",s);
		
		return "calc/result";
	}
	
	
}

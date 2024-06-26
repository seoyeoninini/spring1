package com.sp.app.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 클라이언트 요청시 최초 실행. 
@Controller
@RequestMapping("/calc/*")
public class CalculatorController {
	/* @Autowired를 필드에 붙이고, 
	 의존성을 가진 클래스(CalculatorService라고 쓰여 있지만 구현 클래스 - Impl)에 @Service를 붙인다.  
	*/
	
	@Autowired
	private CalculatorService service;
	
	// @RequestMapping(value = "write", method = RequestMethod.GET)
	@GetMapping("write") // 아래와 어노테이션과 같은 코드
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
	// @RequestMapping(value = "write", method = RequestMethod.POST)
	@PostMapping("write")
	public String submit(int num1, String operator, int num2, Model model) {
		
		/*
		  - 요청을 받는 메소드의 인수이름과 파라미터 이름이 같으면 
		    요청하면서 보낸 파라미터를 받을 수 있다.
		 */
		
		Calculator dto = new Calculator();
		dto.setNum1(num1);
		dto.setNum2(num2);
		dto.setOperator(operator);
		
		int s = service.result(dto);
		
		// Model : 포워딩할 JSP에 넘길 데이터
		model.addAttribute("dto", dto);
		model.addAttribute("result",s);
		
		return "calc/result";
	}
	
	
}

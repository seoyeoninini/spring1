package com.sp.app.calc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc/*")
public class CalculatorController {
	@GetMapping("write")
	public ModelAndView form() {
		return new ModelAndView("calc/write");
	}
	
	@PostMapping("write")
	public ModelAndView submit(Calculator dto) {
		ModelAndView mav = new ModelAndView("calc/result");
		
		return mav;
	}
}

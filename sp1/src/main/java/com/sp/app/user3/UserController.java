package com.sp.app.user3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("user3.userController")
@RequestMapping("/user3/*")
public class UserController {
	
	@GetMapping("main")
	public String main() {
		return "user3/main";
	}
	
	/*
	 - 요청 파라미터를 메소드의 인수로 받기
	   : 요청 파라미터와 인수의 이름이 동일한 경우 요청 파라미터를 받을 수 있다.
	   : 매개변수와 동일한 이름의 요청 파라미터가 없으면 null이 된다.
	 */
	
	/*
	// Integer는 null을 가질 수 있다.
	@GetMapping("request")
	public String execute(
			String name,
			Integer age,
			Model model) {
		
		// int age인 경우 age가 넘어오지 않으면 null이므로 500 에러 발생
		
		String s = name + ":" + age;
		
		model.addAttribute("msg", s);
		
		return "user3/result";
		
	}
	*/
	
	/*
	 - @RequestParam
	   : 요청 파라미터와 메소드의 인수와 매핑
	   : 기본은 필수, 메소드 인수에 대한 요청 파라미터가 없으면 400 에러 
	   : name 속성을 생략하면 스프링 6.1에서 에러가 발생하거나 경고가 발생할 수 있음
	 */
	/*
	@GetMapping("request")
	public String execute(
			@RequestParam(required = false) String name, // 필수가 아님. 즉, null을 허용
			@RequestParam int age,
			Model model) {
		
		// int age인 경우 age가 넘어오지 않으면 null이므로 500 에러 발생
		
		String s = name + ":" + age;
		
		model.addAttribute("msg", s);
		
		return "user3/result";
		
	}
	*/

	@GetMapping("request")
	public String execute(
			@RequestParam(defaultValue = "헿") String name, // defaultValue: 넘어오는 파라미터가 없으면 디폴트값 설정
			@RequestParam(name="age", defaultValue = "0") int a, // name = "보내는 이름" 또는 위처럼 이름 똑같이 설정(String name)헤도 되는데 name 속성으로 쓰기 
			Model model) {
		
		// int age인 경우 age가 넘어오지 않으면 null이므로 500 에러 발생
		
		String s = name + ":" + a;
		
		model.addAttribute("msg", s);
		
		return "user3/result";
		
	}
}

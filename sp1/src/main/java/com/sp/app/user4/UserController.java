package com.sp.app.user4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("user4.userController")
@RequestMapping("/user4/*")
public class UserController {
	
	@GetMapping("write")
	public String form(Model model) {
		
		List<String> list = new ArrayList<String>();
		list.add("대졸");
		list.add("고졸");
		list.add("기타");
		
		model.addAttribute("haks", list);
		
		return "user4/write";
	}
	
	@PostMapping("write")
	public String submit(User user, Model model) {
		
		model.addAttribute("dto", user);
		
		return "user4/result";
	}
	
	/*
	   - @ModelAttribute
	     : 컨트롤러 메소드의 파라미터나 리턴값을 Model 객체와 바인딩 하기 위한 애노테이션
	     : ModelMap.addAttribute("이름",값)의 역할을 한다.
	     : 포워딩할 jsp에 넘길 값들을 넘겨줌
	     : 아래 코드의  경우 memberTypes의 값들을 jsp에 넘겨준다. 
	 */
	
	// 포워딩한 jsp의 리턴값으로 넘어감
	@ModelAttribute("memberTypes")
	public List<String> getMemberTypes() {
		List<String> list = new ArrayList<String>();
		
		list.add("일반회원");
		list.add("기업회원");
		list.add("특별회원");
		
		return list;
	}
	
	/*
	 * @GetMapping 메소드는 특정 URL에 대한 GET 요청을 처리하고, 특정 뷰를 반환하는 역할을 합니다.
@ModelAttribute 메소드는 컨트롤러의 모든 요청에 대해 공통적으로 모델에 데이터를 추가하는 역할을 합니다.
따라서 @GetMapping은 특정 경로의 GET 요청을 처리하기 위해 사용되고, @ModelAttribute는 여러 요청에 걸쳐 공통적으로 필요한 데이터를 모델에 추가하기 위해 사용된 것입니다.
	 * 
	 */
	
}

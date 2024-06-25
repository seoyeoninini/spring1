package com.sp.app.user5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("user5.userController")
@RequestMapping("/user5/*")
public class UserController {
	
	@GetMapping("write")
	public String form() {
		return "user5/write";
	}
	
	@PostMapping("write")
	public String submit(User dto, RedirectAttributes rAttr) {
		
		// 리다이렉트한 페이지에 값 넘기기
		rAttr.addFlashAttribute("dto", dto);
		rAttr.addFlashAttribute("msg", dto.getName() + "님 회원가입을 축하합니다...");
		
		// redirect해서 데이터를 넘겨야할 경우 RedirectAttributes를 이용해서 일회성을 값을 넘겨야 한다. rediect 한 놈에게 정보를 넘겨 줄 수 있음!
		// 파라미터로 넘기는 기존 방식(?키=값&) 로 할 필요가 없음
		// 안그러면 값이 두번 이상 넘어갈 수 있음!
		return "redirect:/user5/complete";
	}
	
	@GetMapping("complete")
	public String complete(@ModelAttribute("dto") User dto) {
		// complete() 메소드의 괄호 안에 인자가 없어도 view 에서는 
		// addFlashAttribute() 에서 설정한 내용이 출력 된다.
		// - F5 키를 눌러 새로고침하면 addFlashAttribute() 에서 넘긴 값은 초기화 된다.
		// - @ModelAttribute("dto")를 이용하여 addFlashAttribute()로 설정한 값을 이곳에서 넘겨 받을 수 있다.
		
		if(dto.getId() == null) {
			// 새로고침 한 경우
			System.out.println("........" + dto.getId());
		}
		
		return "user5/result";
	}
	
}

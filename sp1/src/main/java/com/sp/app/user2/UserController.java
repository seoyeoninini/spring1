package com.sp.app.user2;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 요청 메소드의 리턴 타입
 * - String 리턴 타입
 *   : 리턴 값이 뷰의 이름
 *   : String을 반환하면 내부적으로 ModelandView 객체를 생성하여 처리
 * - ModelandView 리턴 타입
 *   : 처리 결과를 담은 모델객체와 뷰의 정보를 담아 반환
 * - void 리턴 타입
 *   : 메소드 내부에서 Http Response를 직접 처리하는 경우 사용
 *   : 메소드의 인자에 HttpServletResponse가 없는 경우
 *     url이 user2/result 이면 뷰 이름은 "user2/result"가 된다.
 * - Map, Model, ModelMap 리턴 타입
 *   : 뷰의 이름은 자동으로 지정
 *     url이 user2/result 이면 뷰 이름은 "user2/result"가 된다.
 *   : 반환 값은 모델이 된다. 
 *   : ajax, JSON에서 사용
 */

// @Controller() 인자 안의 값이 없을 경우 클래스의 첫글자를 소문자로 하여 만드므로 com.sp.app.user의 userController와 
// 중복되어 충돌이 생겨 오류가 난다. 그러므로 앞에 패키지명을 지정하여 넣기. 
@Controller("user2.userController")
@RequestMapping("/user2/*")
public class UserController {
	@GetMapping("hello")
	public void result(HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<p>환영합니다.</p>");
		out.print("</body></html>");
	}
	
	
	@GetMapping("hello2")
	public Map<String, Object> result2() throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		map.put("msg", "구라같은데 😏 ");
		
		return map;
	}
}

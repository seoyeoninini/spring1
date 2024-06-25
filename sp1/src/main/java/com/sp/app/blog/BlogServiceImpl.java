package com.sp.app.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

	@Override
	public List<Blog> listBlog() {
		List<Blog> list = new ArrayList<>();
		
		list.add(new Blog(1001, "주식부자", "헤헿"));
		list.add(new Blog(1002, "집에갈래", "큥이"));
		list.add(new Blog(1003, "어휴 하기싫어", "명수"));
		list.add(new Blog(1004, "순천은 도시에요", "진명"));
		list.add(new Blog(1005, "자바 공부하자", "서연"));
		
		return list;
		
		// 주소창에 http://localhost:9090/app/blog/1001/home 이라고 나오는데, 1001은 db에서 기본키이다.
		// 주소창에 ?키=값&를 지양해야 한다.
	}

	@Override
	public Blog findById(long blogIdx) {
		List<Blog> list = listBlog();
		
		for(Blog b : list) {
			if(blogIdx == b.getBlogIdx()) {
				return b;
			}
		}
		return null;
	}
	
}

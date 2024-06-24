package com.sp.app.blog;

import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {

	@Override
	public List<Blog> listBlog() {
		List<Blog> list = new ArrayList<>();
		
		list.add(new Blog(1001, "주식부자", "헤헿"));
		list.add(new Blog(1002, "집에갈래", "큥이"));
		list.add(new Blog(1003, "졸립당ㅎ", "명수"));
		list.add(new Blog(1004, "순천은 도시에요", "진명"));
		list.add(new Blog(1005, "자바 공부하자", "서연"));
		
		return list;
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

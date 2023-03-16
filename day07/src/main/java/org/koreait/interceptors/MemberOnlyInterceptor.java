package org.koreait.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.koreait.models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		if (member == null) {
			
			// 로그인 페이지로 이동
			String url = request.getContextPath() + "/user/login";
			response.sendRedirect(url);
			return false;
		}
		
		return true;
	}
	

}

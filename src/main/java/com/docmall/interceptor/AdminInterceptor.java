package com.docmall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.docmall.domain.AdminVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false;
		
		// 현제 클라이언트의 세션을 통한 인증상태 확인을 위한 세션을 받아오는 작업.
		HttpSession session = request.getSession();
		
		// 세션의 로그인 정보를 MemberVO 형태로 담아 작업을 준비한다.
		AdminVO user = (AdminVO) session.getAttribute("adminStatus");
		
		if(user == null) {
			// 인증정보가 없을 경우.
			result = false; // 컨트롤러로 진행하지 못한다.
			
			if(isAjaxRequest(request)) {
				
				response.sendError(400); // 클라이언트의 ajax구문에서 error 동작.
				
			}else {
				
				getTargetUrl(request);
				response.sendRedirect("/admin/intro");
				
			}
			
		}else {
			// 인증정보가 있는 경우. 즉 세션에 loginStatus가 존재(사용자가 로그인 했을 때)
			result = true; // 컨트롤러로 진행하게 된다.
		}
		
		// 리턴되는 값이 true라면 페이지로 넘어가고, false라면 넘어가지 못하게 만들어져 있다.
		return result;
	}

	// 인증되지 않은 상태에서 사용자가 요청한 URL을 저장하고, 로그인 후 URL로 리다이렉트 시켜주는 작업
	private void getTargetUrl(HttpServletRequest request) {
		
		// 요청주소 http://localhost:9090/member/modify?userid=doccomsa
		
		String uri = request.getRequestURI(); // /member/modify
		String query = request.getQueryString(); // userid=doccomsa
		
		if(query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}
		
		String targetUrl = uri + query;
		
		if(request.getMethod().equals("GET")) {
			request.getSession().setAttribute("targetUrl", targetUrl);
		}
	}
	
	// 사용자 요청이 ajax요청인지 체크
	private boolean isAjaxRequest(HttpServletRequest request) {
		
		boolean isAjax = false;
		
		String header = request.getHeader("AJAX");
		if(header != null && header.equals("true")) {
			isAjax = true;
		}
		
		return isAjax;
	}

}

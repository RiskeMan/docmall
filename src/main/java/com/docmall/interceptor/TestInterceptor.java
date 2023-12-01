package com.docmall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;


// 프로젝트에 인터셉터 기능을 적용시키기 위한 준비.
// 인터셉터 클래스를 생성한다.
// HandlerInterceptorAdapter 추상 클래스를 상속한다.
// 주요 3가지 메서드를 재정의한다.

// 인터셉터 클래스를 사용하기 위하여 servlet-context.xml에서 설정해야 한다.
//@Log4j
public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 컨트롤러에서 공통적으로 필요한 작업(인증, 권한, 로깅 등)
		
//		log.info("인터셉터 : preHandle() 호출"); //호출 안 됨
		System.out.println("인터셉터 : preHandle() 호출");
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("인터셉터 : postHandle() 호출");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("인터셉터 : afterCompletion() 호출");
		
		super.afterCompletion(request, response, handler, ex);
	}

}

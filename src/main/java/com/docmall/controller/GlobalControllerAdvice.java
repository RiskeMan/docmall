package com.docmall.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.docmall.domain.CategoryVO;
import com.docmall.service.AdCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/*
 * 컨트롤러의 매핑주소 여청이 넘어가기 전, 이 클래스가 동작이 된다.
  지정한 패키지(com.docmall.controller)에서 반복적으로 사용하는 Model 데이타작업을
  아래 클래스에서 한번만 정의를 해서 사용할 때.
 매번 요청이 발생될 때마다 클래스가 동작된다.(중요)
 
 모든 주소에서 불러와져 실행되기에, 사용하는 경우는 거이 모든 페이지에서 사용 되는 구문을 넣어 사용하는 수준이 아니라면 서버 동작에 부하만 줄 수도 있다. 
 */

@RequiredArgsConstructor
@Log4j
@ControllerAdvice(basePackages = {"com.docmall.controller"})
public class GlobalControllerAdvice {
	
	private final AdCategoryService adCategoryService;
	
	@ModelAttribute // @ModelAttribute는 필수로 들어가야 한다.
	public void getFirstCategoryList(Model model) {
		
//		log.info("1차카테고리 리스트");
		
		// 사용자 : 1차 카테고리 표시 참조, 관리자 : 상품등록의 1차 카테고리 표시 참조
		List<CategoryVO> firstCategoryList = adCategoryService.getFirstCategoryList();
		model.addAttribute("firstCategoryList", firstCategoryList);
	}
}

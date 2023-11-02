package com.docmall.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.docmall.domain.CategoryVO;
import com.docmall.service.AdCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice(basePackages = {"com.docmall.controller"}) // 기본 패키지명을 넣는다.
// ControllerAdvice 지정한 패키지에서 반복적으로 사용되는 Model 데이터 작업을 아래 클래스에서 정의하여 반복적으로 사용할 수 있다.
@RequiredArgsConstructor
public class GlobalControllerAdvice {

	private final AdCategoryService adCategoryService;
	
	@ModelAttribute
	public void getFirstCategoryList(Model model) {
		
		log.info("1차 카테고리 리스트");
		
		List<CategoryVO> firstCategoryList = adCategoryService.getFirstCategoryList();
		model.addAttribute("firstCategoryList", firstCategoryList);
	}
		
	
}

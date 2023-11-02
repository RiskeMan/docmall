package com.docmall.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.docmall.domain.CategoryVO;
import com.docmall.service.AdCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // ajax호출과 일반 호출이 함께 사용되는 경우.
@Log4j
@RequiredArgsConstructor
//@RestController // 모든 매핑주소가 ajax 호출로 사용하는 경우.
@RequestMapping("/admin/category/*")
public class AdCategoryController {

	private final AdCategoryService adCategoryService;
	
	// 1차 카테고리 선택에 따른 2차 카테고리 정보를 클라이언트에게 제공.
	// 일반주소 /admin/category/secondCategory?Cg_Parent_Code=1
	// RestFull 개발론 주소 /admin/category/secondCategory/1.json
	// 주소의 일부분을 값으로 사용하고자 할 경우 {}중괄호로 사용한다.
	@ResponseBody	// @Controller 로 사용할 때, ajax를 사용하기 위해서 넣는 구문.
	@GetMapping("/secondCategory/{cg_parent_code}")
	public ResponseEntity<List<CategoryVO>> secondCategory(@PathVariable("cg_parent_code") Integer cg_parent_code) throws Exception {
	
		log.info("1차 카테고리 코드 : " + cg_parent_code);
		
		ResponseEntity<List<CategoryVO>> entity = null;
		
		entity = new ResponseEntity<List<CategoryVO>>(adCategoryService.getSecondCategoryList(cg_parent_code), HttpStatus.OK);
		
		return entity;
	}
}

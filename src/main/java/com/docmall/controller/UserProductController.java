package com.docmall.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;
import com.docmall.dto.PageDTO;
import com.docmall.service.UserProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/user/product/*")
public class UserProductController {

	private final UserProductService userProductService;
	
	// 매핑주소 1 : /user/product/pro_list?cg_code=2차 카테고리 코드
//	@GetMapping("/pro_list")
//	public void pro_list(Criteria cri, @RequestParam("cg_code") Integer cg_code) throws Exception {
//		
//	}

	// 매핑주소 2 : /user/product/pro_list?2차 카테고리 코드 (REST API 개발형태)
	@GetMapping("/pro_list/{cg_code}")
	public void pro_list(Criteria cri, @PathVariable("cg_code") Integer cg_code, Model model) throws Exception {
		
		// 10 -> 2
		cri.setAmount(2);
		
		List<ProductVO> pro_list = userProductService.pro_list(cg_code, cri);
		
		// 날짜폴더의 역슬래시를 슬래시로 바꾸는 작업.  이유? 역슬래시로 되어있는 정보가 스프링으로 보내는 요청데이타에 사용되면 에러발생.
		// 스프링에서 처리 안하면, 자바스크립트에서 처리할 수도 있다.
		pro_list.forEach(vo -> {
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
		});
		model.addAttribute("pro_list", pro_list);
		
		int totalCount = userProductService.getTalaCount(cg_code);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));

	}
}
	
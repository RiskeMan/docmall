package com.docmall.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;
import com.docmall.dto.PageDTO;
import com.docmall.service.UserProductService;
import com.docmall.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/user/product/*")
public class UserProductController {

	private final UserProductService userProductService;
	
	// 메인및썸네일 이미지업로드 폴더경로 주입작업
	@Resource(name = "uploadPath") // servlet-context.xml 의 bean이름 참조를 해야 함.
	private String uploadPath;
	
	// 매핑주소 1 : /user/product/pro_list?cg_code=2차 카테고리 코드
//	@GetMapping("/pro_list")
//	public void pro_list(Criteria cri, @RequestParam("cg_code") Integer cg_code) throws Exception {
//		
//	}

	// 매핑주소 2 : /user/product/pro_list?2차 카테고리 코드 (REST API 개발형태)
	@GetMapping("/pro_list")
	public String pro_list(Criteria cri, @ModelAttribute("cg_code") Integer cg_code, @ModelAttribute("cg_name") String cg_name, Model model) throws Exception {
		
		// 10 -> 2
		cri.setAmount(4);

		
		List<ProductVO> pro_list = userProductService.pro_list(cg_code, cri);
		
		// 날짜폴더의 역슬래시를 슬래시로 바꾸는 작업.  이유? 역슬래시로 되어있는 정보가 스프링으로 보내는 요청데이타에 사용되면 에러발생.
		// 스프링에서 처리 안하면, 자바스크립트에서 처리할 수도 있다.
		pro_list.forEach(vo -> {
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
		});
		model.addAttribute("pro_list", pro_list);
		
		int totalCount = userProductService.getTotalCount(cg_code);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));

		return "/user/product/pro_list";
	}
	
	// 상품 리스트에서 보여줄 이미지 <img sec="매핑주소">
	@ResponseBody
	@GetMapping("/imageDisplay") // /user/product/imageDisplay?dateFolderName=값1&fileName=값2
	public ResponseEntity<byte[]> imgDisplay(String dateFolderName, String fileName) throws Exception {
			
		return FileUtils.getFile(uploadPath + dateFolderName, fileName);
	}
	
	// 상품 상세 페이지, 하단 상품 후기 포함.
	@GetMapping("/pro_detail")
	public void pro_detail (Criteria cri, Integer cg_code, @ModelAttribute("cg_name") String cg_name, Integer pro_num, Model model) throws Exception {
		
		log.info("페이징 정보 : " + cri);
		log.info("상품코드 : " + pro_num);
		
		ProductVO productVO = userProductService.pro_detail(pro_num);
		// 클라이언트에서 이미지 출력작업. \역슬래시가 서버로 보낼때 문제가 되어 /슬래시로 사용하고자 변경하는 구문.
		productVO.setPro_up_folder(productVO.getPro_up_folder().replace("\\", "/"));
		
		model.addAttribute("productVO", productVO);
		
	}
	
	
}
	
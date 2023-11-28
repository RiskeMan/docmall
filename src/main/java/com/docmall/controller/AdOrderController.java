package com.docmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docmall.domain.OrderVO;
import com.docmall.domain.OrderdetailVO;
import com.docmall.domain.ProductVO;
import com.docmall.domain.ReviewVO;
import com.docmall.dto.Criteria;
import com.docmall.dto.PageDTO;
import com.docmall.service.AdOrderService;
import com.docmall.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/admin/order/*")
public class AdOrderController {

	private final AdOrderService adOrderService;
	
	// 메인및썸네일 이미지업로드 폴더경로 주입작업
	@Resource(name = "uploadPath") // servlet-context.xml 의 bean이름 참조를 해야 함.
	private String uploadPath;
	
	//상품리스트.  (목록과페이징)
	@GetMapping("/order_list")
	public void pro_list(Criteria cri, Model model) throws Exception {
			
		// 10 -> 2
		cri.setAmount(2);
			
//		log.info("리스트 참조" + cri);

		List<OrderVO> order_list = adOrderService.pro_list(cri);
		
		
		// 날짜폴더의 역슬래시를 슬래시로 바꾸는 작업.  이유? 역슬래시로 되어있는 정보가 스프링으로 보내는 요청데이타에 사용되면 에러발생.
		// 스프링에서 처리 안하면, 자바스크립트에서 처리할 수도 있다.
//		pro_list.forEach(vo -> {
//			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
//		});
		model.addAttribute("order_list", order_list);
		
		int totalCount = adOrderService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
	}
	
	@GetMapping("/order_detail_info/{ord_code}")
	public ResponseEntity<List<OrderdetailVO>> list(@PathVariable("ord_code") Integer ord_code) throws Exception {
		
		// 클래스명 = 주문상세 테이블 + 상품테이블을 조인한 결과를 담는 클래스
		
		ResponseEntity<List<OrderdetailVO>> entity = null;

		
		return entity;
	}
	
	// 상품 리스트에서 보여줄 이미지 <img sec="매핑주소">
	@ResponseBody
	@GetMapping("/imageDisplay") // /admin/product/imageDisplay
	public ResponseEntity<byte[]> imgDisplay(String dateFolderName, String fileName) throws Exception {
		
		return FileUtils.getFile(uploadPath + dateFolderName, fileName);
	}
		
}

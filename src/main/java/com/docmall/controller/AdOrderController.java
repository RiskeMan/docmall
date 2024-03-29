package com.docmall.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docmall.domain.OrderDetailInfoVO;
import com.docmall.domain.OrderDetailProductVO;
import com.docmall.domain.OrderVO;
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
	public void pro_list(Criteria cri, @ModelAttribute("start_date") String start_date, @ModelAttribute("end_date") String end_date, Model model) throws Exception {
			
		// 10 -> 2
		cri.setAmount(2);
			
//		log.info("리스트 참조" + cri);

		List<OrderVO> order_list = adOrderService.pro_list(cri, start_date, end_date);
		
		
		// 날짜폴더의 역슬래시를 슬래시로 바꾸는 작업.  이유? 역슬래시로 되어있는 정보가 스프링으로 보내는 요청데이타에 사용되면 에러발생.
		// 스프링에서 처리 안하면, 자바스크립트에서 처리할 수도 있다.
//		pro_list.forEach(vo -> {
//			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
//		});
		model.addAttribute("order_list", order_list);
		
		int totalCount = adOrderService.getTotalCount(cri, start_date, end_date);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
	}
	
	// 주문상세 방법1. 주문상세 정보가 클라이언트 json형태로 변환되어 보내진다.(pom.xml에 jaskson-databind 라이브러리 백그라운드로 작동)
	@GetMapping("/order_detail_info1/{ord_code}")
	public ResponseEntity<List<OrderDetailInfoVO>> order_detail_info1(@PathVariable("ord_code") Long ord_code) throws Exception {
		
		// 클래스명 = 주문상세 테이블 + 상품테이블을 조인한 결과를 담는 클래스
		
		ResponseEntity<List<OrderDetailInfoVO>> entity = null;

		List<OrderDetailInfoVO> OrderDetaiList = adOrderService.orderDetailInfo1(ord_code);
		
		// 윈도우 환경에서 상품이미지 출력시 역슬래시 사용이 문제가 된다. 그렇기에 슬래시로 변환해 클라이언트로 보내준다.
		OrderDetaiList.forEach(vo -> {
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
		});
		
		entity = new ResponseEntity<List<OrderDetailInfoVO>>(OrderDetaiList, HttpStatus.OK);
		
		
		return entity;
	}
	
	// 주문상품 상세내역에서 개별상품 삭제.
	@GetMapping("/order_product_delete")
	public String order_product_delete(Criteria cri, Long ord_code, Integer pro_num) throws Exception {
		
		// 주문상세 개별삭제
		adOrderService.order_product_delete(ord_code, pro_num);
		
		return "redirect:/admin/order/order_list" + cri.getListLink();
	}
	
	// 주문상세 방법2.
	@GetMapping("/order_detail_info2/{ord_code}")
	public String order_detail_info2(@PathVariable("ord_code") Long ord_code, Model model) throws Exception {
		
		List<OrderDetailProductVO> orderProductList = adOrderService.orderDetailInfo2(ord_code);
		
		// 윈도우 환경에서 상품이미지 출력시 역슬래시 사용이 문제가 된다. 그렇기에 슬래시로 변환해 클라이언트로 보내준다.
//		orderProductList.forEach(vo -> {
//			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
//		});
		
		orderProductList.forEach(vo -> {
			vo.getProductVO().setPro_up_folder(vo.getProductVO().getPro_up_folder().replace("\\", "/"));
		});
		
		model.addAttribute("orderProductList", orderProductList);
		
		return "/admin/order/order_detail_product";
	}
	
	// 상품 리스트에서 보여줄 이미지 <img sec="매핑주소">
	@ResponseBody
	@GetMapping("/imageDisplay") // /admin/product/imageDisplay
	public ResponseEntity<byte[]> imgDisplay(String dateFolderName, String fileName) throws Exception {
		
		return FileUtils.getFile(uploadPath + dateFolderName, fileName);
	}
		
}

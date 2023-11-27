package com.docmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docmall.domain.MemberVO;
import com.docmall.domain.ReviewVO;
import com.docmall.dto.Criteria;
import com.docmall.dto.PageDTO;
import com.docmall.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController // jsp파일 생성 안 함.
@Log4j
@RequiredArgsConstructor
@RequestMapping("/user/review/*")
public class ReviewController {

	private final ReviewService reviewService;
	
	// @RequestBody : JSON데이터를 ReviewVO객체로 변환해주는 기능 ... 참고> 반대의미 어노테이션 @ResponseBody
	// ResponseEntity<> 타입을 리턴타입으로 주면 클라이언트에 상태코드 자체를 리턴 형태로 명시적으로 줄 수 있다.
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> review_insert(@RequestBody ReviewVO vo, HttpSession session) throws Exception {
		
		log.info("리뷰 : " + vo);

		String mbsp_id = ((MemberVO) session.getAttribute("loginStatus")).getMbsp_id();
		vo.setMbsp_id(mbsp_id);
		
		ResponseEntity<String> entity = null;
		
		// DB저장
		reviewService.review_insert(vo);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// list?pro_num=10&page=1 -> rest API 개발형태의 주소 list/10/1
	// ResponseEntity<>의 리턴타임값이 String아닌 형태는 ajax에서 
	@GetMapping("/list/{pro_num}/{page}")
	public ResponseEntity<Map<String, Object>> list(@PathVariable("pro_num") Integer pro_num, @PathVariable("page") Integer page) throws Exception {
		
		// 리턴타입에 따른 구문의 차이.
		// - select문
		// ResponseEntity<Map<String, Object>> : 1. 상품후기 목록 데이터 - List<ReviewVO> 2. 페이징 데이터 - PageDTO
		// 자바에서 리턴타입은 단 하나만 보낼 수 있기에 Map으로 묶어 하나의 데이터 타입으로 내 보내는 것. 
		// ResponseEntity<List<ReviewVO>> : 상품후기 목록 데이터 - List<ReviewVO>
		// ResponseEntity<PageDTO> : 페이징 데이터 - PageDTO
		
		// - insert, delete, update
		// ResponseEntity<String>

		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();

		// 1. 상품후기목록 데이터
		Criteria cri = new Criteria();
		cri.setAmount(5); // 크리테라의 amount 값을 5로 바꿔 5개의 list만 받게 하는 구문 
		cri.setPageNum(page);
				
		// db연동
		List<ReviewVO> list = reviewService.list(pro_num, cri);
		
		// 2. 페이징 데이터
		int listCount = reviewService.listCount(pro_num);
		PageDTO pageMaker = new PageDTO(cri, listCount);
		
		map.put("list", list); // 상품후기목록 데이터 - List<ReviewVO>
		map.put("pageMaker", pageMaker); // 페이징 데이터 - PageDTO
		
		// jackson-databind 라이브러리에 의하여 map -> json으로 번환되어 ajax를 호출한 쪽으로 리턴값이 보내진다.
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
	}
	
	// 상품후기 삭제
	@DeleteMapping("/delete/{rew_num}") // /user/review/delete/1
	public ResponseEntity<String> delete(@PathVariable("rew_num") Long rew_num) throws Exception {
		ResponseEntity<String> entity = null;
		
		// db연동작업
		reviewService.delete(rew_num);
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	@PutMapping(value = "/modify", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> review_modify(@RequestBody ReviewVO vo, HttpSession session) throws Exception {
		
		log.info("리뷰 : " + vo);

		String mbsp_id = ((MemberVO) session.getAttribute("loginStatus")).getMbsp_id();
		vo.setMbsp_id(mbsp_id);
		
		ResponseEntity<String> entity = null;
		
		// DB저장
		reviewService.review_modify(vo);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
}

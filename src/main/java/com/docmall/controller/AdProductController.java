package com.docmall.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docmall.domain.ProductVO;
import com.docmall.service.AdProductService;
import com.docmall.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/product/*")
@RequiredArgsConstructor
public class AdProductController {

	private final AdProductService adProductService;
	
	// 업로드 폴더경로 주입작업
	@Resource(name = "uploadPath") // servlet-context.xml 에서 bean 생성 후 참조.
	private String uploadPath;
	
	
	// 상품 등록 폼
	@GetMapping("pro_insert")
	public void pro_insert() {
		
		log.info("상품 등록 폼");
		
	}
	
	// 1차 카테고리 데이터를 Model로 작업
	
	
	// 상품정보 저장
	// 파일 업로드 기능 : 1) 스프링에 내장된 기본 라이브러리 servlet-context.xml 에서 multipartResolver의 beans 작업
	//				2) 외부 라이블러리를 이용.(commons-fileupload)를 이용.(pom.xml). servlet-context.xml 
	// 				에서 multipartResolver의 beans 작업이 되어 이용 할 수 있다.
	// MultipartFile uploadFile :
	// <input type="file" class="form-control" name="uploadFile" id="uploadFile">
	@PostMapping("/pro_insert")
	public String pro_insert(ProductVO vo, MultipartFile uploadFile, RedirectAttributes rttr) {
		
		log.info("상품정보 :" + vo);
		
		// 1) 파일 업로드 작업. 선수작업 : FileUtils 클래스 작업
		String dateFolder = FileUtils.getDateFolder();
		String savedFileName = FileUtils.uploadFile(uploadPath, dateFolder, uploadFile);
		
		vo.setPro_img(savedFileName);
		vo.setPro_up_folder(dateFolder);
		
		// 2) 상품정보 DB저장.
		adProductService.pro_insert(vo);
		
		return "redirect:/pro_insert";
	}
	
	
}

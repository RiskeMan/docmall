package com.docmall.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

// 파일 업로드 관련으로 필요한 메서드를 구성.
public class FileUtils {

	// 날자 폴더 생성을 위한 날자 정보
	public static String getDateFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String str = sdf.format(date);
		
		// File.separator : 각 OS별로 경로구분자를 변환
		// 유닉스, 맥, 리눅스 구분자/ 예) "2023-11-02" -> "2023-11-02" 
		// 윈도우즈 구분자 \ 예) "2023-11-02" -> 2023\11\02 
		return str.replace("-", File.separator); // 예) "2023-11-02"
	}
	
	// 서버에 파일 업로드 기능 및 실제 업로드 한 파일명 변환
	public static String uploadFile(String uploadFolder, String DateFolder, MultipartFile uploadFile) {
		
		String realUploadFileName = ""; // 실제 업로드한 파일이름(파일이름 중복방지)
		
		// File : 파일과 폴더 관련 작업을 하는 기능.
		File file = new File(uploadFolder, DateFolder);
		// 예) "C:/div/upload" "2023/11/02"
		
		if(file.exists() == false) {
			file.mkdirs(); // mkdirs() 경로에 맞는 위치의 폴더가 없다면 모두 생성해 준다.
		}
		
		String clientFileName = uploadFile.getOriginalFilename();
		
		// 파일명의 중복방지를 위하여 고유한 이름에 사용하는 UUID
		UUID uuid = UUID.randomUUID();
		realUploadFileName = uuid.toString() + "_" + clientFileName;
		
		try {
			// file : "C:/div/upload/2023/11/02" + realUploadFileName : 업로드할 파일명
			File saveFile = new File(file, realUploadFileName);
			// 파일업로드(파일복사)
			uploadFile.transferTo(saveFile); // 파일업로드의 핵심 메소드
		} catch (Exception e) {
			e.printStackTrace(); // 파일 업로드시 예외가 발생되면, 예외 정보를 출력
		}
		
		
		return realUploadFileName; // 상품 테이블에 상품이미지명으로  저장된다.
	}
	
}

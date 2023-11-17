package com.docmall.kakaopay;

import java.util.Date;

import lombok.Data;

// 결제준비요청(1차) 의 응답결과를 저장하기 위한 클래스.
@Data
public class ReadyResponse {

	private String tid; // 결제 고유 번호, 20자
	
//	private String next_redirect_app_url; // 요청한 클라이언트(Client)가 모바일 앱일 경우
//	private String next_redirect_mobile_url; // 요청한 클라이언트가 모바일 웹일 경우
	private String next_redirect_pc_url	; // 요청한 클라이언트가 PC 웹일 경우
	
	private String android_app_scheme; // 카카오페이 결제 화면으로 이동하는 Android 앱 스킴(Scheme)
	private String ios_app_scheme; // 카카오페이 결제 화면으로 이동하는 iOS 앱 스킴
	private Date Datetime; // 결제 준비 요청 시간
}

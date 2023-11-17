package com.docmall.kakaopay;

import java.util.Date;

import lombok.Data;

// 결제승인요청(2차) 의 응답결과를 저장하기 위한 클래스.
/*
	2) 결제 승인요청
	메서드	URL	인증 방식
	POST	https://kapi.kakao.com/v1/payment/approve	서비스 앱 어드민 키

	>> 응답2를 받기위한 클래스 : ApproveResponse
 */
@Data
public class ApproveResponse {

	
	private String aid; // 요청 고유 번호O
	private String tid; // 결제 고유 번호
	private String cid; // 가맹점 코드
	private String sid; // 정기 결제용 ID, 정기 결제 CID로 단건 결제 요청 시 발급
	private String partner_order_id; //	가맹점 주문번호, 최대 100자
	
	private Amount amount; // 결제 금액 정보

//	private CardInfo card_info; // 결제 상세 정보, 결제수단이 카드일 경우만 포함

	private String item_name; // 상품 이름, 최대 100자
	private String item_code; // 상품 코드, 최대 100자
	private Integer quantity; // 상품 수량

	private Date created_at; // 결제 준비 요청 시각
	private Date approved_at; // 결제 승인 시각
	private String payload; // 결제 승인 요청에 대해 저장한 값, 요청 시 전달된 내용

}
package com.docmall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
/*
CREATE TABLE ORDER_TBL(
        ORD_CODE            NUMBER                  PRIMARY KEY, -- 주문 코드
        MBSP_ID             VARCHAR2(15)            NOT NULL, -- 구매자 ID
        ORD_NAME            VARCHAR2(30)            NOT NULL, -- 수령자 성명
        ORD_ZIPCODE         CHAR(5)                 NOT NULL, -- 우편주소
        ORD_ADDR_BASIC      VARCHAR2(50)            NOT NULL, -- 주소
        ORD_ADDR_DETAIL     VARCHAR2(50)            NOT NULL, -- 상세주소
        ORD_TEL             VARCHAR2(20)            NOT NULL, -- 전화번호
        ORD_PRICE           NUMBER                  NOT NULL, -- 총주문금액. 선택
        ORD_REGDATE         DATE DEFAULT SYSDATE    NOT NULL, -- 주문날자
        ORD_STATUS          VARCHAR2(20)            NOT NULL, -- 주문 상태
        PAYMENT_STATUS      VARCHAR2(20)            NOT NULL, -- 결제 상태
        FOREIGN KEY(MBSP_ID)    REFERENCES MBSP_TBL(MBSP_ID)
);
 */
	
	private Long ord_code; // 주문코드
	private String mbsp_id; // 구매자 ID
	private String ord_name; // 수령자 성명
	
	private String ord_zipcode; // 우편주소
	private String ord_addr_basic; // 주소
	private String ord_addr_detail; // 상세주소
	
	private String ord_tel; // 전화번호
	
	private int ord_price; // 주문금액
	
	private Date ord_regdate; // 주문날자
	
	private String ord_status; // 주문상태
	private String payment_status; // 결제상태
	
	
}

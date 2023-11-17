package com.docmall.domain;

import java.util.Date;

public class PaymentVO {
/*
CREATE TABLE PAYMENT (
    TAY_CODE            NUMBER          PRIMARY KEY,   -- 일련번호
    ODR_CODE            NUMBER          NOT NULL,   -- 주문번호
    MBSP_ID             VARCHAR2(50)    NOT NULL,   -- 회원 ID
    PAY_METHOD          VARCHAR2(50)    NOT NULL,   -- 결제방식
    PAY_DATE            DATE            NULL,       -- 결제일
    PAY_TOT_PRICE       NUMBER          NOT NULL,   -- 결제금액
    PAY_NOBANK_PRICE    NUMBER          NOT NULL,   -- 무통장입급금액
    PAY_REST_PRICE      NUMBER          NULL,       -- 미지급금
    PAY_NOBANK_USER     VARCHAR2(50)    NULL,       -- 무통장 입금자명
    PAY_NOBANK          VARCHAR2(50)    NULL,       -- 입금은행
    
    PAY_NAME            VARCHAR2(100)    NULL       -- 메모
);
 */
	
	private Integer tay_code; // 일련번호
	private Long odr_code; // 주문번호
	
	private String mbsp_id; // 회원 ID
	private String pay_method; // 결제방식
	private Date pay_date; // 결제일
	private int pay_tot_price; // 결제금액
	private int pay_nobank_price; // 무통장입급금액
	private int pay_rest_price; // 미지급금
	private String pay_nobank_user; // 무통장 입금자명
	private String pay_nobank; // 입금은행
	private String pay_name; // 메모
	
}

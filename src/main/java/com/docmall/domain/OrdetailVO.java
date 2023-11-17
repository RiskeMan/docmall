package com.docmall.domain;

import lombok.Data;

@Data
public class OrdetailVO {
/*
CREATE TABLE ORDETAIL_TBL(
        ORD_CODE        NUMBER      NOT NULL REFERENCES ORDER_TBL(ORD_CODE), -- 주문 번호.
        PRO_NUM         NUMBER      NOT NULL REFERENCES PRODUCT_TBL(PRO_NUM), -- 상품번호
        DT_AMOUNT       NUMBER      NOT NULL, -- 주문된 상품의 갯수
        DT_PRICE        NUMBER      NOT NULL,  -- 역정규화 -- 상품의 가격
        PRIMARY KEY (ORD_CODE ,PRO_NUM) 
);
 */
	// ord_code, pro_num, dt_amount, dt_price
	
	private Long ord_code; // 주문코드
	
	private int pro_num; // 상품번호
	private int dt_amount; // 주문된 상품의 갯수
	private int dt_price; // 상품의 가격
	
}

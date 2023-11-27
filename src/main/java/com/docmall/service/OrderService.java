package com.docmall.service;

import com.docmall.domain.OrderVO;
import com.docmall.domain.PaymentVO;

public interface OrderService {

	int getOrderseq();
	
	// 주문하기
	void order_insert(OrderVO vo, PaymentVO p_vo); // 주문테이블에 저장
	
//	void order_detail_insert(OrdetailVO vo);
//
//	void order_detail_insert(Long ord_code, String mbsp_id);

}

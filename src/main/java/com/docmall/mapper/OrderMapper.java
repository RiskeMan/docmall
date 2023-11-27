package com.docmall.mapper;

import org.apache.ibatis.annotations.Param;

import com.docmall.domain.OrderVO;
import com.docmall.domain.PaymentVO;

public interface OrderMapper {

	int getOrderseq(); // 주문번호에 사용할 시퀀스
	
	// 주문하기
	// 1. 주문 테이블 저장
	void order_insert(OrderVO vo); // 주문테이블에 저장
	
//	void order_detail_insert(OrdetailVO vo); // 사용 안 함.
	// 2. 주문 상세테이블 저장 -> 장바구니 테이블 참조.
	void order_detail_insert(@Param("ord_code") Long ord_code, @Param("mbsp_id") String mbsp_id);
	
	// 3. 장바구니 테이블 삭제
	void cart_del(String mbsp_id);
	
	// 4. 결제 테이블 저장
	void payment_insert(PaymentVO p_vo);
	
	
}

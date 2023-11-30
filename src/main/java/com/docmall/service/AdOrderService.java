package com.docmall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.docmall.domain.OrderDetailInfoVO;
import com.docmall.domain.OrderDetailProductVO;
import com.docmall.domain.OrderVO;
import com.docmall.dto.Criteria;

public interface AdOrderService {

	List<OrderVO> pro_list(Criteria cri, String start_date, String end_date);
	
	int getTotalCount(Criteria cri, String start_date, String end_date);
	
	List<OrderDetailInfoVO> orderDetailInfo1(Long ord_code);
	
	List<OrderDetailProductVO> orderDetailInfo2(Long ord_code);
	
	void order_product_delete(Long ord_code, Integer pro_num);
}

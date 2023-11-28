package com.docmall.service;

import java.util.List;

import com.docmall.domain.OrderVO;
import com.docmall.dto.Criteria;

public interface AdOrderService {

	List<OrderVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
}

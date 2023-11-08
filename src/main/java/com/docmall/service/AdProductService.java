package com.docmall.service;

import java.util.List;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;

public interface AdProductService {
	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	// @Param 어노미테이션은 Mapper에서만 사용된다.
	// pro_checked_modify 에서 배열로 받아온다.
	void pro_checked_modify1(
			List<Integer> pro_num_arr,
			List<Integer> pro_price_arr,
			List<String> pro_buy_arr
	);
	
	void pro_checked_modify2(
			List<Integer> pro_num_arr,
			List<Integer> pro_price_arr,
			List<String> pro_buy_arr
	);
	
	ProductVO pro_edit(Integer pro_num);
	
	void pro_edit(ProductVO vo);
	
	void pro_delete(Integer pro_num);
	
}

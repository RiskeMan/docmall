package com.docmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.docmall.domain.CategoryVO;
import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;
import com.docmall.dto.ProductDTO;

public interface AdProductMapper {

	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	// 파라미터가 2개 이상 사용되는 경우 경우@Param("") 어노테이션이 필수.
	// 방법 1
	void pro_checked_modify1(
			@Param("pro_num") Integer pro_num,
			@Param("pro_price") Integer pro_price,
			@Param("pro_buy") String pro_buy
	);
	
	// 방법2
	void pro_checked_modify2(List<ProductDTO> pro_modify_list);
	
	//
	ProductVO pro_edit(Integer pro_num);
	
	// 상품 수정
	void pro_edit_ok(ProductVO vo);
	
	void pro_delete(Integer pro_num);
	
}

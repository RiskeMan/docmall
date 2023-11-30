package com.docmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.docmall.domain.OrderDetailInfoVO;
import com.docmall.domain.OrderDetailProductVO;
import com.docmall.domain.OrderVO;
import com.docmall.dto.Criteria;

public interface AdOrderMapper {

	// 페이징 기능의 목록과 토탈 카운트는 연동되는 작업이기에 같은 속성을 입력받아야 한다.
	List<OrderVO> pro_list(@Param("cri") Criteria cri, @Param("start_date") String start_date, @Param("end_date") String end_date);
	
	int getTotalCount(@Param("cri") Criteria cri, @Param("start_date") String start_date, @Param("end_date") String end_date);
	
	List<OrderDetailInfoVO> orderDetailInfo1(Long ord_code);
	
	// 기존 클래스 OrderDetailVO와 ProductVO가 필드로 있는 클래스. mybatis에서는 orderDetailProductMap사용.
	List<OrderDetailProductVO> orderDetailInfo2(Long ord_code);
	
	void order_product_delete(@Param("ord_code") Long ord_code, @Param("pro_num") Integer pro_num);
}

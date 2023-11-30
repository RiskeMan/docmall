package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.OrderDetailInfoVO;
import com.docmall.domain.OrderDetailProductVO;
import com.docmall.domain.OrderVO;
import com.docmall.dto.Criteria;
import com.docmall.mapper.AdOrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdOrderServiceImpl implements AdOrderService {

	private final AdOrderMapper adOrderMapper;

	@Override
	public List<OrderVO> pro_list(Criteria cri, String start_date, String end_date) {
		// TODO Auto-generated method stub
		
		// start_date와 end_date 값에 null값이 존재할 경우, 기본값을 주는 형식으로 만들어 볼 위치
		
		return adOrderMapper.pro_list(cri, start_date, end_date);
	}

	@Override
	public int getTotalCount(Criteria cri, String start_date, String end_date) {
		// TODO Auto-generated method stub
		return adOrderMapper.getTotalCount(cri, start_date, end_date);
	}

	@Override
	public List<OrderDetailInfoVO> orderDetailInfo1(Long ord_code) {
		// TODO Auto-generated method stub
		return adOrderMapper.orderDetailInfo1(ord_code);
	}

	@Override
	public List<OrderDetailProductVO> orderDetailInfo2(Long ord_code) {
		// TODO Auto-generated method stub
		return adOrderMapper.orderDetailInfo2(ord_code);
	}

	@Override
	public void order_product_delete(Long ord_code, Integer pro_num) {
		// TODO Auto-generated method stub
		adOrderMapper.order_product_delete(ord_code, pro_num);
	}

	
}

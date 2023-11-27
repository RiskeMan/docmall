package com.docmall.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docmall.domain.OrderVO;
import com.docmall.domain.PaymentVO;
import com.docmall.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderMapper orderMapper;

	@Override
	public int getOrderseq() {
		// TODO Auto-generated method stub
		return orderMapper.getOrderseq();
	}

	@Transactional // 트랜잭션(중요) root-context.xml에서 트랜잭션이 설정되어있어야 적용된다.
	@Override
	public void order_insert(OrderVO o_vo, PaymentVO p_vo) {
		// TODO Auto-generated method stub
		orderMapper.order_insert(o_vo);
		orderMapper.order_detail_insert(o_vo.getOrd_code(), o_vo.getMbsp_id());
		orderMapper.cart_del(o_vo.getMbsp_id());
		orderMapper.payment_insert(p_vo);
	}
	
	
	
}

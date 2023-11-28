package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.OrderVO;
import com.docmall.dto.Criteria;
import com.docmall.mapper.AdOrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdOrderServiceImpl implements AdOrderService {

	private final AdOrderMapper adOrderMapper;

	@Override
	public List<OrderVO> pro_list(Criteria cri) {
		// TODO Auto-generated method stub
		return adOrderMapper.pro_list(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return adOrderMapper.getTotalCount(cri);
	}
	
}

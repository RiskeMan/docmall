package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;
import com.docmall.mapper.UserProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class UserProductServiceImpl implements UserProductService {

	private final UserProductMapper userProductMapper;

	@Override
	public List<ProductVO> pro_list(Integer cg_code, Criteria cri) {
		// TODO Auto-generated method stub
		return userProductMapper.pro_list(cg_code, cri);
	}

	@Override
	public int getTotalCount(Integer cg_code) {
		// TODO Auto-generated method stub
		return userProductMapper.getTotalCount(cg_code);
	}

	@Override
	public ProductVO pro_detail(Integer pro_num) {
		// TODO Auto-generated method stub
		return userProductMapper.pro_detail(pro_num);
	}
}

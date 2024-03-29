package com.docmall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.docmall.domain.ReviewVO;
import com.docmall.dto.Criteria;

public interface ReviewService {

	void review_insert(ReviewVO vo);
	
	List<ReviewVO> list(Integer pro_num, Criteria cri);
	
	int listCount(Integer pro_num);
	
	void delete(Long rew_num);

	void review_modify(ReviewVO vo);

}

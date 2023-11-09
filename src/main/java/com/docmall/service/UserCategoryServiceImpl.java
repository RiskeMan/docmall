package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.CategoryVO;
import com.docmall.mapper.UserCategoryMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service // 해당 클래스의 UserCategoryServiceImpl bean이 자동 생성.
/*
	<!-- service 패키지 -->
	<context:component-scan base-package="com.docmall.service" />
	이 자동으로 생성되게 만들어준다.
 */
@RequiredArgsConstructor
@Log4j
public class UserCategoryServiceImpl implements UserCategoryService {

	private final UserCategoryMapper userCategoryMapper;
	// @Service 주입을 정상적으로 받는다는 전제조건 하에 
	// @RequiredArgsConstructor가 자동으로 의존성을 주입 시켜준다.

	@Override
	public List<CategoryVO> getSecondCategoryList(Integer cg_parent_code) {
		// TODO Auto-generated method stub
		return userCategoryMapper.getSecondCategoryList(cg_parent_code);
	}
	
	
}

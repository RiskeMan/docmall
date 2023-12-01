package com.docmall.mapper;

import java.util.List;

import com.docmall.domain.CategoryVO;

// 인터페이스가 bean으로 생성되는 것이 아니라, 아래 Proxy Class가 객체(Bean)이 생성되어
// AdCategoryServiceImpl 클래스 안에 주입(DI)되어 진행된다.
// 매퍼 클래스를 상속받는 프록시(Proxy class)가 생성되고 객체생성이 이루어진다.
public interface AdCategoryMapper {

	List<CategoryVO> getFirstCategoryList();
	
	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
	
	CategoryVO get(Integer pro_num);
}

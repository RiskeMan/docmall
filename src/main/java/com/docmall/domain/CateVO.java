package com.docmall.domain;

import lombok.Data;

@Data
public class CateVO {

	private Integer cate_code; // 1, 2차 모든카테고리코드
	private Integer cate_parent_code; // 1차카테고리코드
	private String 	cate_name;
}

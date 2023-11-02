package com.docmall.domain;

import lombok.Data;

// Cg_Code, Cg_Name, Cg_Parent_Code
@Data
public class CategoryVO {

	private Integer cg_code;		// 모든 카테고리 번호.
	private Integer cg_parent_code;	// 상위 카테고리 번호.
	private String cg_name;			// 카테고리명
	
}

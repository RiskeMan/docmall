package com.docmall.domain;

// cg_code, cg_parent_code, cg_name
public class CategoryVO {

	// 테이블의 컬럼명과 필드명을 동일하게 함.
	// 동일하지 않음 : 1. 컬럼명 as별칭, 2. mybatis resultMap 사용으로 대체. 
	private Integer cg_code; // 1, 2차 모든카테고리코드
	private Integer cg_parent_code; // 1차카테고리코드
	private String cg_name;
	
	// @Getter, @Setter
	public Integer getCg_code() {
		return cg_code;
	}
	public void setCg_code(Integer cg_code) {
		this.cg_code = cg_code;
	}
	public Integer getCg_parent_code() {
		return cg_parent_code;
	}
	public void setCg_parent_code(Integer cg_parent_code) {
		this.cg_parent_code = cg_parent_code;
	}
	public String getCg_name() {
		return cg_name;
	}
	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	
	// @ToString
	@Override
	public String toString() {
		return "CategoryVO [cg_code=" + cg_code + ", cg_parent_code=" + cg_parent_code + ", cg_name=" + cg_name + "]";
	}
	
	
}

package com.docmall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 모든 필드를 대사응로 매개변수가 있는 생성자 메서드 생성
@Data
public class ProductDTO {

	private Integer pro_num;
	
	private	int pro_price;
	private	String pro_buy;

	/*
	@AllArgsConstructor 가 생성해 준다.
	
	public ProductDTO(Integer pro_num, int pro_price, String pro_buy) {
		super();
		this.pro_num = pro_num;
		this.pro_price = pro_price;
		this.pro_buy = pro_buy;
	}
	*/
	
	
	
}

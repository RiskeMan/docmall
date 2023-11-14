package com.docmall.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTOList {

	// c.cart_code, c.pro_num, c.cart_amount, 
	// p.pro_name, p.pro_price, p.pro_discount, p.pro_publisher, p.pro_content,
	// p.pro_up_folder, p.pro_img, p.pro_amount, p.pro_buy, p.pro_date, p.pro_updatedate
	
	// cart의 리스트 데이터를 담을 DTO List 테이블.
	
	private Long cart_code;
	private Integer pro_num;
	private	int cart_amount;
	
	private	String	pro_name;
	private	int		pro_price;
	private	int		pro_discount;
	
	private	String	pro_publisher;
	private String	pro_content;
	
	private	String	pro_up_folder;
	private	String	pro_img;
	private	int		pro_amount;
	private	String	pro_buy;
	
	private	Date	pro_date;
	private	Date	pro_updatedate;
}

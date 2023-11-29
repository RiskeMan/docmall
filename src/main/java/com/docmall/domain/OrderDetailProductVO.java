package com.docmall.domain;

import lombok.Data;

@Data
public class OrderDetailProductVO {

	// 기존 클래스. mybatis에서는 resultMap형태로 나타내준다.(orderDetailInfo2)
	private OrderdetailVO orderdetailVO; // collection 으로 표현
	private ProductVO productVO; // collection 으로 표현
}

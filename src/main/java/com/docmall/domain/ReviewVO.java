package com.docmall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {

/*
--7.리뷰 테이블
CREATE TABLE REVIEW_TBL(
        REW_NUM         NUMBER,
        MBSP_ID         VARCHAR2(15)                NOT NULL,
        PRO_NUM         NUMBER                      NOT NULL,
        REW_CONTENT     VARCHAR2(200)               NOT NULL,
        REW_SCORE       NUMBER                      NOT NULL,
        REW_REGDATE     DATE DEFAULT SYSDATE        NOT NULL,
        FOREIGN KEY(MBSP_ID) REFERENCES MBSP_TBL(MBSP_ID),
        FOREIGN KEY(PRO_NUM) REFERENCES PRODUCT_TBL(PRO_NUM)
);
 */
	// , , , , , 
	
	private Long rew_num;
	private String mbsp_id;
	private Integer pro_num;
	private String rew_content;
	private Integer rew_score;
	private Date rew_regdate;

}

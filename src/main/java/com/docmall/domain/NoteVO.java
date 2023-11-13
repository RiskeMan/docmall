package com.docmall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoteVO {
/*
-- 메모장 테이블

CREATE TABLE NOTEPAD(
    NOTE_NUM                NUMBER,
    NOTE_NAME               VARCHAR2(50)            NOT NULL,
    NOTE                    VARCHAR2(1000),
    NOTE_NEW_DATE           DATE DEFAULT SYSDATE    NOT NULL,
    ADMIN_ID                VARCHAR2(15)            NOT NULL,
    FOREIGN KEY(ADMIN_ID)   REFERENCES ADMIN_TBL(ADMIN_ID),
    CONSTRAINT PK_NOTE_NUM  PRIMARY KEY(NOTE_NUM)
);
 */
	
	private int note_num;
	
	private String note_name;
	private String note;
	
	private Date note_new_date;
	
	private String admin_id;
	
}

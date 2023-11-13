package com.docmall.service;

import com.docmall.mapper.NoteMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
public class NoteServiceImpl implements NoteService {

	private final NoteMapper noteMapper;
	
}

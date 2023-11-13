package com.docmall.service;

import org.springframework.stereotype.Service;

import com.docmall.mapper.CartMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class CartServiceImpl implements CartService {

	private final CartMapper cartMapper;
	
	
}

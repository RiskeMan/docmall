package com.docmall.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docmall.domain.NoteVO;
import com.docmall.service.NoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/admin/include/*")
@RequiredArgsConstructor
public class NoteController {

	private final NoteService noteService;
	
	
	@GetMapping("/note")
	public void note(NoteVO vo) {
		
	}
	
	
	@PostMapping("/note")
	public void note(NoteVO vo, Model model) {
		
	}
}

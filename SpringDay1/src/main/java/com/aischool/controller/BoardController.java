package com.aischool.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aischool.entity.Board;
import com.aischool.mapper.BoardMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {
	
	@Autowired // SqlSessionFatoryBean
	private BoardMapper mapper;
	
	// 게시글 입력기능 - url : controller/insert.do
	@PostMapping("/insert.do")
	public String insert(HttpServletRequest request) {
		
		System.out.println("게시글 입력 기능실행");
		
		// 파일업로드 기능
		MultipartRequest multi = null;
		
		int fileMaxSize = 5000 * 1024 * 10;
		String savePath = request.getRealPath("resources/board");
		System.out.println("저장되는 경로 : " + savePath);
		
		DefaultFileRenamePolicy def = new DefaultFileRenamePolicy();

		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", def);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB에 게시글 저장하기
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		String imgpath = multi.getFilesystemName("imgpath");
		
		Board vo = new Board();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setImgpath(imgpath);
		
		mapper.insert(vo);
		
		return "redirect:/list.do";
		
	}
	
	
	// 게시글 작성 페이지 이동 url : controller/form.do
	@GetMapping("/form.do")
	public String form() {
		System.out.println("게시글 작성페이지 이동 기능 실행");
		return "form";
	}
	
	
	// 게시글 상세보기 - url : controller/content.do
	@GetMapping("/content.do")
	public String content(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 상세보기 기능실행");
		
		Board vo = mapper.content(idx);
		
		model.addAttribute("vo", vo);
		
		return "content";
		
	}
	
	// 게시글 전체보기 - url : controller/list.do
	@RequestMapping("/list.do")
	public String list(Model model) {
		// 게시글 전체보기 했을때 실행 될 메소드(함수)
		System.out.println("게시글 전체보기 기능실행");
		
		ArrayList<Board> list = mapper.list();
		
		// model 안에 게시글 목록 저장
		model.addAttribute("list", list);
		
		// list.jsp 페이지로 이동
		return "list";
		
	}
	
	
}

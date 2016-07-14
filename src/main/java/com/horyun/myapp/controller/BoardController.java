package com.horyun.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.horyun.myapp.HomeController;
import com.horyun.myapp.domain.BoardVO;
import com.horyun.myapp.service.BoardService;
import com.horyun.myapp.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/*")//똑같은 경로를 미리 설정해준다
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registGet(){
		
		return "/board/register";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registPost(BoardVO board, RedirectAttributes model) throws Exception{
		logger.info("board : " + board.toString());
		service.regist(board); //command객체로 
		model.addFlashAttribute("msg", "SUCCESS"); 
		//success메세지는 한번만 뜨면 되니까 session에서의 한번처리 이후 사라지는 flash를 쓴다
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		logger.info("show all list...");
		model.addAttribute("list", service.listAll());
		return "/board/listAll";
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") Integer bno, Model model) throws Exception {
		//BoardVO boardVO = service.read(bno);
		//model.addAttribute("boardVO", boardVO);
		//return "/board/read"; //같을 경우 생략가능
		//requestparam을 쓰면 정수로 바꿔주지 않아도 된다
		model.addAttribute(service.read(bno));
		
	}
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String modify(BoardVO board, RedirectAttributes model) throws Exception{
		logger.info("board : " + board.toString());
		service.regist(board); //command객체로 
		model.addFlashAttribute("msg", "SUCCESS"); 
		//success메세지는 한번만 뜨면 되니까 session에서의 한번처리 이후 사라지는 flash를 쓴다
		return "redirect:/board/listAll";
	}
}

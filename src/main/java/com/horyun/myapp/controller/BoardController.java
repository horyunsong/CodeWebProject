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
@RequestMapping("/board/*")//�Ȱ��� ��θ� �̸� �������ش�
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
		service.regist(board); //command��ü�� 
		model.addFlashAttribute("msg", "SUCCESS"); 
		//success�޼����� �ѹ��� �߸� �Ǵϱ� session������ �ѹ�ó�� ���� ������� flash�� ����
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
		//return "/board/read"; //���� ��� ��������
		//requestparam�� ���� ������ �ٲ����� �ʾƵ� �ȴ�
		model.addAttribute(service.read(bno));
		
	}
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String modify(BoardVO board, RedirectAttributes model) throws Exception{
		logger.info("board : " + board.toString());
		service.regist(board); //command��ü�� 
		model.addFlashAttribute("msg", "SUCCESS"); 
		//success�޼����� �ѹ��� �߸� �Ǵϱ� session������ �ѹ�ó�� ���� ������� flash�� ����
		return "redirect:/board/listAll";
	}
}

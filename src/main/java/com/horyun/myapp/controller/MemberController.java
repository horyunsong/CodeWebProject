package com.horyun.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.horyun.myapp.domain.MemberVO;
import com.horyun.myapp.service.MemberService;
import com.horyun.myapp.service.MemberServiceImpl;
import com.horyun.myapp.util.MemberValidation;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberServiceImpl service;
	
	@RequestMapping(value="/login")
	public void login() {
		//����
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginComplete(@Valid MemberVO member, BindingResult result, HttpServletRequest req) {
		logger.info("loginComplete:" + member.toString());
		if(result.hasErrors()){
			//�̸� ������ �ִ��� �˻��ϰ� ����������
			return "/member/login";
		}
		/*
		try {
			//���⼭ Ȯ���Ѵ�
			MemberVO vo = service.readWithPW(member.getUserid(), member.getUserpw());
			if(vo == null) {
				return "/member/login";
			}
		}
		catch(Exception err) {
			return "/member/login";
		}
		*/
		
		try{
			//dao���� Ȯ���Ѵ�
			MemberVO vo = service.readWithPW(member.getUserid(), member.getUserpw());
			WebUtils.setSessionAttribute(req, "USER_KEY", vo);
		}
		catch(Exception err) {
			return "/member/login";
		}
		return "home";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest req){
		req.getSession().invalidate(); //session�� ����Ѵ�
		return "home";
	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		//���� ȣ��Ǿ� Ȯ���Ѵ�
		binder.setValidator(new MemberValidation());
	}
}


















